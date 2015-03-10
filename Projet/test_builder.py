import os
import re
import sys


def gentest(f):
    labels = {}

    result_lines = []
    instr_pattern = re.compile(r'^[^#]*#\s*(.*)$')
    label_pattern = re.compile('^([a-zA-Z0-9_]+):$')
    ref_pattern = re.compile('^@([a-zA-Z0-9_]+)$')
    pc = 1
    for line in f.readlines():
        result = instr_pattern.match(line)
        if result:
            instr = result.group(1)
            label = label_pattern.match(instr)
            if label:
                labels[label.group(1)] = pc
            else:
                atoms = tuple(("%d %s" % (pc, instr)).split())
                pc += len(atoms) - 1
                result_lines.append(atoms)

    result = ""
    for t_line in result_lines:
        for i in range(len(t_line)):
            if i == 0:
                result += t_line[i].rjust(4) + ' '
            elif i == 1:
                result += ' ' + t_line[i].ljust(10)
            else:
                label = ref_pattern.match(t_line[i])
                if label:
                    val = str(labels[label.group(1)])
                else:
                    val = t_line[i]
                result += val.rjust(7)
        result += '\n'

    return result


if __name__ == '__main__':
    for arg in sys.argv:
        if arg.endswith('.pro'):
            with open(arg, 'r') as f:
                gentest_contents = gentest(f)
            filename = arg[:-4] + '.gen'
            contents = "FICHIER %s : \n\n" % filename
            contents += gentest_contents
            filename = arg[:-4] + '.test.gen'
            with open(filename, 'w') as f:
                f.write(contents)

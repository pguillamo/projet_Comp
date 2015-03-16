import os
import re
import sys


def gentest(f):
    labels = {}
    definitions = {}

    parsed_lines = []
    result_lines = []

    def_pattern = re.compile(r'^#\s*([a-z0-9_]+)\s*=\s*(.*[^\s])\s*$', re.I)
    instr_pattern = re.compile(r'^[^#]+#\s*(.*)$')
    label_pattern = re.compile('^([a-z0-9_]+):$', re.I)
    ref_pattern = re.compile('^@([a-z0-9_]+)$', re.I)

    pc = 1

    lines = f.readlines()


    for line in lines:
        definition = def_pattern.match(line)
        if definition:
            definitions[definition.group(1)] = definition.group(2)
        else:
            parsed_lines.append(line % definitions)

    for line in parsed_lines:
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
            elif i == 2:
                label = ref_pattern.match(t_line[i])
                if label:
                    val = str(labels[label.group(1)])
                else:
                    val = t_line[i]
                if val == 'faux':
                    val = '0'
                if val == 'vrai':
                    val = '1'
                result += val.rjust(7)
            else:
                val = t_line[i]
                if val in ('FIX', 'LOC'):
                    val = '0'
                elif val == 'MOD':
                    val = '1'
                result += val.rjust(4)
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

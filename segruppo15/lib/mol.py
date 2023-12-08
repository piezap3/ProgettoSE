import sys

def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        return False

def moltiplicazione(a, b):
    return a * b

# Verifica se sono stati passati almeno due numeri come argomenti
if len(sys.argv) == 3 and all(is_number(arg) or arg.isdigit() for arg in sys.argv[1:]):
    try:
        num1 = float(sys.argv[1])
        num2 = float(sys.argv[2])

        # Esegui la moltiplicazione
        risultato = moltiplicazione(num1, num2)
        print(int(risultato))
    except ValueError:
        print("Assicurati di passare numeri come argomenti.")
else:
    print("Assicurati di passare esattamente due numeri come argomenti.")

import sys

def stampa_argomenti():
    args = sys.argv[1:]  # Prendi gli argomenti da riga di comando, escludendo il nome dello script
    if args:
        print("Argomenti ricevuti:")
        for arg in args:
            print(arg)
    else:
        print("Nessun argomento ricevuto.")

if __name__ == "__main__":
    stampa_argomenti()


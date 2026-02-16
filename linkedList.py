class Node:
    def __init__(self, nim, name):
        self.nim = nim
        self.name = name
        self.next = None

head = None
size = 0
MAX = 10

def menu():
    print("\n=== STUDENT LINKED LIST MENU ===")
    print("1. Insert at beginning")
    print("2. Insert at given position")
    print("3. Insert at end")
    print("4. Delete from beginning")
    print("5. Delete given position")
    print("6. Delete from end")
    print("7. Delete first occurrence")
    print("8. Show data")
    print("9. Exit")

def input_nim():
    while True:
        nim = input("ENTER NIM (numbers only): ")
        if nim.isdigit():
            return nim
        else:
            print("NIM MUST BE NUMBERS ONLY!")

def input_name():
    while True:
        name = input("ENTER NAME (letters only): ")
        if name.replace(" ", "").isalpha():
            return name
        else:
            print("NAME MUST BE LETTERS ONLY!")

def insert(pos):
    global head, size

    if size == MAX:
        print("DATA IS FULL!")
        return

    nim = input_nim()
    name = input_name()
    new_node = Node(nim, name)

    if pos == 0:
        new_node.next = head
        head = new_node
    else:
        temp = head
        for _ in range(pos - 1):
            temp = temp.next
        new_node.next = temp.next
        temp.next = new_node

    size += 1

def delete(pos):
    global head, size

    if size == 0:
        print("EMPTY DATA!")
        return

    if pos == 0:
        head = head.next
    else:
        temp = head
        for _ in range(pos - 1):
            temp = temp.next
        temp.next = temp.next.next

    size -= 1

def show_data():
    if size == 0:
        print("EMPTY DATA!")
        return

    temp = head
    i = 1
    while temp:
        print(f"{i}. NIM: {temp.nim} | Name: {temp.name}")
        temp = temp.next
        i += 1


while True:
    menu()
    try:
        choice = int(input("SELECT MENU: "))

        if choice == 1:
            insert(0)

        elif choice == 2:
            pos = int(input(f"ENTER POSITION (1-{size+1}): ")) - 1
            if 0 <= pos <= size:
                insert(pos)
            else:
                print("INVALID POSITION!")

        elif choice == 3:
            insert(size)

        elif choice == 4:
            delete(0)

        elif choice == 5:
            pos = int(input(f"ENTER POSITION (1-{size}): ")) - 1
            if 0 <= pos < size:
                delete(pos)
            else:
                print("INVALID POSITION!")

        elif choice == 6:
            delete(size - 1)

        elif choice == 7:
            delete(0)

        elif choice == 8:
            show_data()

        elif choice == 9:
            print("PROGRAM COMPLETED.")
            break

        else:
            print("INVALID MENU!")

    except ValueError:
        print("INPUT MUST BE NUMBER!")

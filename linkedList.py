MAX = 10
head = None
size = 0
counter = 0

class Node:
    def __init__(self, nim, name, order):
        self.nim = nim
        self.name = name
        self.order = order
        self.next = None

def input_nim():
    while True:
        nim = input("Input NIM (numbers only): ")
        if nim.isdigit():
            return nim
        print("NIM must be numbers only!")

def input_name():
    while True:
        name = input("Input Name (letters only): ")
        if name.replace(" ", "").isalpha():
            return name
        print("Name must be letters only!")

def insert(pos):
    global head, size, counter

    if size == MAX:
        print("DATA IS FULL!")
        return

    nim = input_nim()
    name = input_name()

    counter += 1
    new_node = Node(nim, name, counter)

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
    print("Data inserted successfully.")

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
    print("Data deleted successfully.")

def delete_first_inserted():
    global head, size

    if size == 0:
        print("EMPTY DATA!")
        return

    temp = head
    prev = None
    smallest = temp.order
    target = temp
    target_prev = None

    while temp:
        if temp.order < smallest:
            smallest = temp.order
            target = temp
            target_prev = prev
        prev = temp
        temp = temp.next

    if target_prev is None:
        head = target.next
    else:
        target_prev.next = target.next

    size -= 1
    print("First inserted data deleted.")

def display():
    if size == 0:
        print("EMPTY DATA!")
        return

    temp = head
    print("\nCurrent Data:")
    while temp:
        print("NIM:", temp.nim, "| Name:", temp.name)
        temp = temp.next
    print()

while True:
    print("\n=== STUDENT MENU ===")
    print("1. Insert at beginning")
    print("2. Insert at given position")
    print("3. Insert at end")
    print("4. Delete from beginning")
    print("5. Delete from given position")
    print("6. Delete from end")
    print("7. Delete first occurence")
    print("8. Show data")
    print("9. Exit")

    choice = input("Choose menu: ")

    if choice == "1":
        insert(0)

    elif choice == "2":
        if size == 0:
            print("EMPTY DATA!")
        else:
            try:
                pos = int(input("Position (1 - {}): ".format(size + 1))) - 1
                if 0 <= pos <= size:
                    insert(pos)
                else:
                    print("Invalid position!")
            except:
                print("Position must be number!")

    elif choice == "3":
        insert(size)

    elif choice == "4":
        delete(0)

    elif choice == "5":
        if size == 0:
            print("EMPTY DATA!")
        else:
            try:
                pos = int(input("Position (1 - {}): ".format(size))) - 1
                if 0 <= pos < size:
                    delete(pos)
                else:
                    print("Invalid position!")
            except:
                print("Position must be number!")

    elif choice == "6":
        delete(size - 1)

    elif choice == "7":
        delete_first_inserted()

    elif choice == "8":
        display()

    elif choice == "9":
        print("Program finished.")
        break

    else:
        print("Invalid choice!")

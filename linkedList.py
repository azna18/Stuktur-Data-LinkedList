class Mhs:
    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.count = 0

    def insert_awal(self, nim, nama):
        n = Mhs(nim, nama)
        n.next = self.head
        self.head = n
        self.count += 1

    def insert_akhir(self, nim, nama):
        n = Mhs(nim, nama)
        if not self.head:
            self.head = n
        else:
            t = self.head
            while t.next:
                t = t.next
            t.next = n
        self.count += 1

    def insert_pos(self, nim, nama, pos):
        if pos < 1 or pos > self.count + 1: return
        if pos == 1:
            self.insert_awal(nim, nama)
            return
        n = Mhs(nim, nama)
        t = self.head
        for _ in range(pos - 2):
            t = t.next
        n.next = t.next
        t.next = n
        self.count += 1

    def delete_awal(self):
        if not self.head: return
        self.head = self.head.next
        self.count -= 1

    def delete_akhir(self):
        if not self.head: return
        if not self.head.next:
            self.head = None
        else:
            t = self.head
            while t.next.next:
                t = t.next
            t.next = None
        self.count -= 1

    def delete_pos(self, pos):
        if pos < 1 or pos > self.count: return
        if pos == 1:
            self.delete_awal()
            return
        t = self.head
        for _ in range(pos - 2):
            t = t.next
        t.next = t.next.next
        self.count -= 1

    def delete_nim(self, nim):
        if not self.head: return
        if self.head.nim == nim:
            self.head = self.head.next
            self.count -= 1
            return
        t = self.head
        while t.next and t.next.nim != nim:
            t = t.next
        if t.next:
            t.next = t.next.next
            self.count -= 1

    def show(self):
        t = self.head
        i = 1
        while t:
            print(f"{i}. {t.nim} - {t.nama}")
            t = t.next
            i += 1
        print("Jumlah:", self.count)


l = LinkedList()

while True:
    print("1.Insert Awal")
    print("2.Insert Posisi")
    print("3.Insert Akhir")
    print("4.Delete Awal")
    print("5.Delete Posisi")
    print("6.Delete Akhir")
    print("7.Delete by NIM")
    print("8.Show")
    print("9.Exit")
    p = int(input("Pilih: "))

    if p == 1:
        l.insert_awal(input("NIM: "), input("Nama: "))
    elif p == 2:
        pos = int(input("Posisi: "))
        l.insert_pos(input("NIM: "), input("Nama: "), pos)
    elif p == 3:
        l.insert_akhir(input("NIM: "), input("Nama: "))
    elif p == 4:
        l.delete_awal()
    elif p == 5:
        l.delete_pos(int(input("Posisi: ")))
    elif p == 6:
        l.delete_akhir()
    elif p == 7:
        l.delete_nim(input("NIM: "))
    elif p == 8:
        l.show()
    elif p == 9:
        break

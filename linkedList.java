import java.util.Scanner;

class Node {
    String nim, nama; Node next;
    Node(String nim, String nama){ this.nim=nim; this.nama=nama; }
}

class LL {
    Node head; int count=0;

    void insertAwal(String nim,String nama){
        Node n=new Node(nim,nama);
        n.next=head; head=n; count++;
    }

    void insertAkhir(String nim,String nama){
        Node n=new Node(nim,nama);
        if(head==null) head=n;
        else{ Node t=head; while(t.next!=null)t=t.next; t.next=n; }
        count++;
    }

    void insertPos(String nim,String nama,int pos){
        if(pos<1||pos>count+1)return;
        if(pos==1){insertAwal(nim,nama);return;}
        Node n=new Node(nim,nama), t=head;
        for(int i=1;i<pos-1;i++) t=t.next;
        n.next=t.next; t.next=n; count++;
    }

    void deleteAwal(){
        if(head==null)return;
        head=head.next; count--;
    }

    void deleteAkhir(){
        if(head==null)return;
        if(head.next==null) head=null;
        else{ Node t=head; while(t.next.next!=null)t=t.next; t.next=null; }
        count--;
    }

    void deletePos(int pos){
        if(pos<1||pos>count)return;
        if(pos==1){deleteAwal();return;}
        Node t=head;
        for(int i=1;i<pos-1;i++) t=t.next;
        t.next=t.next.next; count--;
    }

    void deleteNim(String nim){
        if(head==null)return;
        if(head.nim.equals(nim)){head=head.next;count--;return;}
        Node t=head;
        while(t.next!=null&&!t.next.nim.equals(nim)) t=t.next;
        if(t.next!=null){ t.next=t.next.next; count--; }
    }

    void show(){
        Node t=head; int i=1;
        while(t!=null){ System.out.println(i+". "+t.nim+" - "+t.nama); t=t.next; i++; }
        System.out.println("Jumlah: "+count);
    }
}

public class linkedList {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        LL l=new LL(); int p;
        do{
            System.out.println("\n1.Insert Awal\n2.Insert Posisi\n3.Insert Akhir");
            System.out.println("4.Delete Awal\n5.Delete Posisi\n6.Delete Akhir");
            System.out.println("7.Delete by NIM\n8.Show\n9.Exit");
            System.out.print("Pilih: "); p=s.nextInt();
            switch(p){
                case 1: System.out.print("NIM: ");String n1=s.next();
                        System.out.print("Nama: ");String nm1=s.next();
                        l.insertAwal(n1,nm1); break;
                case 2: System.out.print("Posisi: ");int pos=s.nextInt();
                        System.out.print("NIM: ");String n2=s.next();
                        System.out.print("Nama: ");String nm2=s.next();
                        l.insertPos(n2,nm2,pos); break;
                case 3: System.out.print("NIM: ");String n3=s.next();
                        System.out.print("Nama: ");String nm3=s.next();
                        l.insertAkhir(n3,nm3); break;
                case 4: l.deleteAwal(); break;
                case 5: System.out.print("Posisi: ");l.deletePos(s.nextInt()); break;
                case 6: l.deleteAkhir(); break;
                case 7: System.out.print("NIM: ");l.deleteNim(s.next()); break;
                case 8: l.show(); break;
            }
        }while(p!=9);
    }
}

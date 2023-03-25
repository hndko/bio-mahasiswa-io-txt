/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2_eko;

import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class bioMahasiswa extends JFrame implements ActionListener {

    JLabel judul = new JLabel();
    JLabel nim = new JLabel();
    JLabel nama = new JLabel();
    JLabel alamat = new JLabel();
    JLabel jkelamin = new JLabel();
    JLabel prodi = new JLabel();
    JLabel jurusan = new JLabel();
    String Nama, Nim, jk, Alamat, Studi, Jurusan;
    JTextField txtnim = new JTextField();
    JTextField txtnama = new JTextField();
    JRadioButton rd_l, rd_p;
    JTextArea TXTalamat = new JTextArea();
    JScrollPane scroll;
    JComboBox<String> jc_prodi, jc_jurusan;
    JButton simpan = new JButton();
    JButton baca = new JButton();
    JButton keluar = new JButton();
    JComboBox<String> box;
    JRadioButton rd, rd1, rd2;
    ButtonGroup br;

    public bioMahasiswa() {
        Font Judul = new Font("Times New Roman", Font.BOLD, 22);
        Font isi = new Font("Times New Roman", Font.PLAIN, 14);
        judul.setFont(Judul);
        nim.setFont(isi);
        nama.setFont(isi);
        alamat.setFont(isi);
        jkelamin.setFont(isi);
        prodi.setFont(isi);
        jurusan.setFont(isi);
        simpan.setFont(isi);
        baca.setFont(isi);
        keluar.setFont(isi);
        judul.setText("Biodata Mahasiswa");
        judul.setBounds(180, 10, 250, 30);
        add(judul);
        nim.setText("NIM");
        nim.setBounds(50, 70, 100, 25);
        add(nim);
        txtnim.setBounds(190, 70, 180, 25);
        add(txtnim);
        nama.setText("Nama");
        nama.setBounds(50, 105, 100, 25);
        add(nama);
        txtnama.setBounds(190, 105, 280, 25);
        add(txtnama);
        alamat.setText("Alamat");
        alamat.setBounds(50, 140, 100, 25);
        add(alamat);
        TXTalamat.setBounds(190, 140, 300, 70);
        scroll = new JScrollPane(TXTalamat);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(190, 140, 300, 70);
        add(scroll);
        jkelamin.setText("Jenis Kelamin");
        jkelamin.setBounds(50, 220, 150, 25);
        add(jkelamin);

        //radio button
        rd_l = new JRadioButton("Pria");
        rd_l.setBounds(190, 220, 80, 25);
        add(rd_l);
        rd_p = new JRadioButton("Wanita");
        rd_p.setBounds(290, 220, 80, 25);
        add(rd_p);
        prodi.setText("Program Studi");
        prodi.setBounds(50, 255, 150, 25);
        add(prodi);

        //jcombobox
        String pilih[] = {"-PILIH-", "D3", "S1", "S2"};
        jc_prodi = new JComboBox<>(pilih);
        jc_prodi.setBounds(190, 255, 170, 25);
        add(jc_prodi);
        jurusan.setText("Jurusan");
        jurusan.setBounds(50, 295, 150, 25);
        add(jurusan);
        jc_jurusan = new JComboBox<>();
        jc_jurusan.setBounds(190, 295, 170, 25);
        jc_jurusan.addItem("-PILIH-");
        jc_jurusan.addItem("Sistem Informasi");
        jc_jurusan.addItem("Teknik Informatika");
        jc_jurusan.addItem("Manajemen Informatika");
        add(jc_jurusan);
        simpan.setText("Simpan");
        simpan.setBounds(50, 350, 100, 25);
        simpan.addActionListener(this);
        add(simpan);
        baca.setText("Baca Data");
        baca.setBounds(185, 350, 150, 25);
        baca.addActionListener(this);
        add(baca);
        keluar.setText("Keluar");
        keluar.setBounds(370, 350, 100, 25);
        keluar.addActionListener(this);
        add(keluar);

        /*inisiasi frame*/
        setLayout(null);
        setTitle("Form Biodata Mahasiswa");
        setSize(520, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        bioMahasiswa mhs = new bioMahasiswa();
    }

    public void BuatFile() throws IOException {
        String nameFile = "hasil_input.txt";
        FileOutputStream outFile = new FileOutputStream(nameFile);
        try {
            DataOutputStream outStream = new DataOutputStream(outFile);
            outStream.writeUTF("NIM           : " + Nim);
            outStream.writeUTF("Nama          : " + Nama);
            outStream.writeUTF("Alamat        : " + Alamat);
            outStream.writeUTF("Jenis Kelamin : " + jk);
            outStream.writeUTF("Program Studi : " + Studi);
            outStream.writeUTF("Jurusan       : " + Jurusan);
            outStream.close();
            JOptionPane.showMessageDialog(this, "Data Berhasil Di Simpan");
        } catch (IOException e) {
            System.err.println("IOERROR : " + e.getMessage() + "\n");
        }
    }

    public void BacaFile() throws IOException {
        String nameFile = "hasil_input.txt";
        String nim;
        String nama;
        String alamat;
        String jkelamin;
        String prodi;
        String jurusan;
        String isi;
        try {
            FileInputStream inFile = new FileInputStream(nameFile);
            DataInputStream inStream = new DataInputStream(inFile);
            nim = inStream.readUTF();
            nama = inStream.readUTF();
            alamat = inStream.readUTF();
            jkelamin = inStream.readUTF();
            prodi = inStream.readUTF();
            jurusan = inStream.readUTF();
            isi = nim + "\n" + nama + "\n" + alamat + "\n" + jkelamin + "\n" + prodi + "\n" + jurusan;
            inStream.close();
            System.out.println(isi);
        } catch (FileNotFoundException e) {
            System.err.println("File " + nameFile + "Tidak Ada! \n");
        } catch (IOException ex) {
            System.err.println("IOERROR : " + ex.getMessage() + "\n");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Simpan")) {
            Nama = txtnama.getText();
            Nim = txtnim.getText();
            Alamat = TXTalamat.getText();
            if (rd_l.isSelected()) {
                jk = "Pria";
            } else {
                jk = "Wanita";
            }
            Studi = (String) jc_prodi.getSelectedItem();
            Jurusan = (String) jc_jurusan.getSelectedItem();
            try {
                BuatFile();
            } catch (IOException ex) {
            }
        } else if (e.getActionCommand().equals("Baca Data")) {
            try {
                BacaFile();
            } catch (IOException ex) {
            }
        } else {
            dispose();
        }
    }
}

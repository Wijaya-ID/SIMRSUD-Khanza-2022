/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgRujuk.java
 *
 * Created on 31 Mei 10, 20:19:56
 */

package laporan;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author perpustakaan
 */
public final class DlgKLPCM extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i=0;
    private Date date = new Date();
    /** Creates new form DlgRujuk
     * @param parent
     * @param modal */
    public DlgKLPCM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(628,674);

        tabMode=new DefaultTableModel(null,new Object[]{
                "Tanggal Setor","No.Rawat","Tanggal Masuk","No.R.M.","Nama Pasien","Kamar","Bayar","Dokter","ID","Medis","Intgrs",
                "Kep","IC","LOp","Keterangan","Status DRM","Tanggal Diserahkan","Tanggal Diterima","L/TL"
                
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbObat.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbObat.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 19; i++) {
            TableColumn column = tbObat.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(95);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(90);
            }else if(i==3){
                column.setPreferredWidth(60);
            }else if(i==4){
                column.setPreferredWidth(180);
            }else if(i==5){
                column.setPreferredWidth(160);
            }else if(i==6){
                column.setPreferredWidth(80);
            }else if(i==7){
                column.setPreferredWidth(110);
            }else if(i==6){
                column.setPreferredWidth(100);
            }else if(i==8){
                column.setPreferredWidth(40);
            }else if(i==9){
                column.setPreferredWidth(40);
            }else if(i==10){
                column.setPreferredWidth(40);
            }else if(i==11){
                column.setPreferredWidth(40);
            }else if(i==12){
                column.setPreferredWidth(40);
            }else if(i==13){
                column.setPreferredWidth(40);
            }else if(i==14){
                column.setPreferredWidth(90);
            }else if(i==15){
                column.setPreferredWidth(90);
            }else if(i==16){
                column.setPreferredWidth(100);
            }else if(i==17){
                column.setPreferredWidth(90);
            }else if(i==18){
                column.setPreferredWidth(60);
            }else if(i==19){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbObat.setDefaultRenderer(Object.class, new WarnaTable());
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));
        TCari.setDocument(new batasInput((int)100).getKata(TCari));
        
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }
        
        ChkInput.setSelected(false);
        isForm();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbObat = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jLabel4 = new widget.Label();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        TNoRM = new widget.TextBox();
        jLabel13 = new widget.Label();
        jLabel16 = new widget.Label();
        Kamar = new widget.TextBox();
        jLabel28 = new widget.Label();
        jLabel14 = new widget.Label();
        Intgrs = new widget.ComboBox();
        ID = new widget.ComboBox();
        Medis = new widget.ComboBox();
        IC = new widget.ComboBox();
        jLabel15 = new widget.Label();
        Kep = new widget.ComboBox();
        jLabel17 = new widget.Label();
        jLabel18 = new widget.Label();
        LOp = new widget.ComboBox();
        jLabel5 = new widget.Label();
        Tanggalkrs = new widget.Tanggal();
        jLabel20 = new widget.Label();
        jLabel8 = new widget.Label();
        Keterangan = new widget.TextBox();
        Status = new widget.TextBox();
        jLabel9 = new widget.Label();
        Dokter = new widget.TextBox();
        jLabel10 = new widget.Label();
        JBayar = new widget.TextBox();
        jLabel11 = new widget.Label();
        jLabel12 = new widget.Label();
        jLabel22 = new widget.Label();
        LTL = new widget.ComboBox();
        tglditerima = new widget.Tanggal();
        Tanggal = new widget.Tanggal();
        tgldiserahkan = new widget.Tanggal();
        ChkInput = new widget.CekBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data KLPCM Pasien Rawat Inap]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);
        Scroll.setPreferredSize(new java.awt.Dimension(452, 80));

        tbObat.setAutoCreateRowSorter(true);
        tbObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbObat.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbObat.setName("tbObat"); // NOI18N
        tbObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbObatMouseClicked(evt);
            }
        });
        tbObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbObatKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbObat);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tanggal :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(67, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-02-2022" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-02-2022" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(200, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('3');
        BtnCari.setToolTipText("Alt+3");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass9.add(BtnCari);

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass9.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(LCount);

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setBackground(new java.awt.Color(250, 255, 245));
        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(100, 230));
        FormInput.setLayout(null);

        jLabel4.setText("No.Rawat :");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(10, 10, 71, 23);

        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(100, 10, 130, 23);

        TPasien.setEditable(false);
        TPasien.setName("TPasien"); // NOI18N
        TPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TPasienKeyPressed(evt);
            }
        });
        FormInput.add(TPasien);
        TPasien.setBounds(340, 10, 309, 23);

        TNoRM.setEditable(false);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRMKeyPressed(evt);
            }
        });
        FormInput.add(TNoRM);
        TNoRM.setBounds(230, 10, 100, 23);

        jLabel13.setText("Medis :");
        jLabel13.setName("jLabel13"); // NOI18N
        FormInput.add(jLabel13);
        jLabel13.setBounds(170, 100, 40, 23);

        jLabel16.setText("Tanggal KRS :");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setVerifyInputWhenFocusTarget(false);
        FormInput.add(jLabel16);
        jLabel16.setBounds(10, 40, 71, 23);

        Kamar.setEditable(false);
        Kamar.setName("Kamar"); // NOI18N
        Kamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KamarKeyPressed(evt);
            }
        });
        FormInput.add(Kamar);
        Kamar.setBounds(650, 10, 100, 23);

        jLabel28.setText("ID :");
        jLabel28.setName("jLabel28"); // NOI18N
        FormInput.add(jLabel28);
        jLabel28.setBounds(30, 100, 50, 23);

        jLabel14.setText("Intgrs :");
        jLabel14.setName("jLabel14"); // NOI18N
        FormInput.add(jLabel14);
        jLabel14.setBounds(290, 100, 40, 23);

        Intgrs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AS", "TL" }));
        Intgrs.setName("Intgrs"); // NOI18N
        Intgrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntgrsActionPerformed(evt);
            }
        });
        FormInput.add(Intgrs);
        Intgrs.setBounds(340, 100, 50, 22);

        ID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AS", "TL" }));
        ID.setName("ID"); // NOI18N
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        FormInput.add(ID);
        ID.setBounds(100, 100, 50, 20);

        Medis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AS", "TL" }));
        Medis.setName("Medis"); // NOI18N
        Medis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedisActionPerformed(evt);
            }
        });
        FormInput.add(Medis);
        Medis.setBounds(220, 100, 50, 22);

        IC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AS", "TL" }));
        IC.setName("IC"); // NOI18N
        IC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ICActionPerformed(evt);
            }
        });
        FormInput.add(IC);
        IC.setBounds(580, 100, 50, 22);

        jLabel15.setText("IC :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(530, 100, 40, 23);

        Kep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AS", "TL" }));
        Kep.setName("Kep"); // NOI18N
        Kep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KepActionPerformed(evt);
            }
        });
        FormInput.add(Kep);
        Kep.setBounds(460, 100, 60, 22);

        jLabel17.setText("Kep :");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(410, 100, 40, 23);

        jLabel18.setText("LOp :");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(640, 100, 40, 23);

        LOp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AS", "TL" }));
        LOp.setName("LOp"); // NOI18N
        LOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOpActionPerformed(evt);
            }
        });
        FormInput.add(LOp);
        LOp.setBounds(690, 100, 50, 22);

        jLabel5.setText("Jenis Bayar :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(200, 40, 71, 23);

        Tanggalkrs.setForeground(new java.awt.Color(50, 70, 50));
        Tanggalkrs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-02-2022" }));
        Tanggalkrs.setDisplayFormat("dd-MM-yyyy");
        Tanggalkrs.setName("Tanggalkrs"); // NOI18N
        Tanggalkrs.setOpaque(false);
        Tanggalkrs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalkrsKeyPressed(evt);
            }
        });
        FormInput.add(Tanggalkrs);
        Tanggalkrs.setBounds(100, 40, 100, 23);

        jLabel20.setText("Tanggal Setor:");
        jLabel20.setName("jLabel20"); // NOI18N
        jLabel20.setVerifyInputWhenFocusTarget(false);
        FormInput.add(jLabel20);
        jLabel20.setBounds(0, 70, 80, 23);

        jLabel8.setText("Keterangan :");
        jLabel8.setName("jLabel8"); // NOI18N
        FormInput.add(jLabel8);
        jLabel8.setBounds(10, 130, 90, 23);

        Keterangan.setName("Keterangan"); // NOI18N
        Keterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganKeyPressed(evt);
            }
        });
        FormInput.add(Keterangan);
        Keterangan.setBounds(120, 130, 300, 23);

        Status.setName("Status"); // NOI18N
        Status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                StatusKeyPressed(evt);
            }
        });
        FormInput.add(Status);
        Status.setBounds(480, 130, 260, 23);

        jLabel9.setText("Status :");
        jLabel9.setName("jLabel9"); // NOI18N
        FormInput.add(jLabel9);
        jLabel9.setBounds(410, 130, 60, 23);

        Dokter.setName("Dokter"); // NOI18N
        Dokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DokterKeyPressed(evt);
            }
        });
        FormInput.add(Dokter);
        Dokter.setBounds(470, 40, 280, 23);

        jLabel10.setText("Dokter :");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(410, 40, 50, 23);

        JBayar.setName("JBayar"); // NOI18N
        JBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBayarActionPerformed(evt);
            }
        });
        JBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBayarKeyPressed(evt);
            }
        });
        FormInput.add(JBayar);
        JBayar.setBounds(280, 40, 130, 23);

        jLabel11.setText("TGL Diserahkan :");
        jLabel11.setName("jLabel11"); // NOI18N
        FormInput.add(jLabel11);
        jLabel11.setBounds(10, 160, 90, 23);

        jLabel12.setText("TGL Diterima :");
        jLabel12.setName("jLabel12"); // NOI18N
        FormInput.add(jLabel12);
        jLabel12.setBounds(240, 160, 70, 23);

        jLabel22.setText("L / TL :");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(480, 160, 40, 23);

        LTL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "TL" }));
        LTL.setName("LTL"); // NOI18N
        LTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LTLActionPerformed(evt);
            }
        });
        FormInput.add(LTL);
        LTL.setBounds(530, 160, 50, 22);

        tglditerima.setForeground(new java.awt.Color(50, 70, 50));
        tglditerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-02-2022" }));
        tglditerima.setDisplayFormat("dd-MM-yyyy");
        tglditerima.setName("tglditerima"); // NOI18N
        tglditerima.setOpaque(false);
        tglditerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tglditerimaKeyPressed(evt);
            }
        });
        FormInput.add(tglditerima);
        tglditerima.setBounds(320, 160, 100, 23);

        Tanggal.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-02-2022" }));
        Tanggal.setDisplayFormat("dd-MM-yyyy");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setOpaque(false);
        Tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKeyPressed(evt);
            }
        });
        FormInput.add(Tanggal);
        Tanggal.setBounds(100, 70, 100, 23);

        tgldiserahkan.setForeground(new java.awt.Color(50, 70, 50));
        tgldiserahkan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-02-2022" }));
        tgldiserahkan.setDisplayFormat("dd-MM-yyyy");
        tgldiserahkan.setName("tgldiserahkan"); // NOI18N
        tgldiserahkan.setOpaque(false);
        tgldiserahkan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgldiserahkanKeyPressed(evt);
            }
        });
        FormInput.add(tgldiserahkan);
        tgldiserahkan.setBounds(110, 160, 100, 23);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('I');
        ChkInput.setText(".: Input Data");
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            isRawat();
            isPsien();
        }else{            
            //Valid.pindah(evt,TTmpRujuk,TDiagnosa);
        }
}//GEN-LAST:event_TNoRwKeyPressed

    private void TPasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPasienKeyPressed
        //Valid.pindah(evt,TDokter,BtnSimpan);
}//GEN-LAST:event_TPasienKeyPressed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
       // iscombo();
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"pasien");
        }else{
                   if(ID.getSelectedItem().equals("TIDAK") && Medis.getSelectedItem().equals("TIDAK") && Intgrs.getSelectedItem().equals("TIDAK")){
                       JOptionPane.showMessageDialog(null,"Maaf, Pilih IYA salah satu data KLPCM Untuk Menyimpan.!");
                   }else{
                        if(Sequel.menyimpantf("data_klpcm","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","no_rawat",16,new String[]{
                                Valid.SetTgl(Tanggal.getSelectedItem()+""),TNoRw.getText(),Valid.SetTgl(Tanggalkrs.getSelectedItem()+""),JBayar.getText(),
                            Dokter.getText(),ID.getSelectedItem().toString(),Medis.getSelectedItem().toString(),Intgrs.getSelectedItem().toString(),
                            Kep.getSelectedItem().toString(),IC.getSelectedItem().toString(),LOp.getSelectedItem().toString(),Keterangan.getText(),
                            Status.getText(),Valid.SetTgl(tgldiserahkan.getSelectedItem()+""),Valid.SetTgl(tglditerima.getSelectedItem()+""),LTL.getSelectedItem().toString()
                            })==true){
                                tampil();
                                emptTeks();
                        } 
                   }
        }
        
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
        ChkInput.setSelected(true);
        isForm(); 
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            emptTeks();
        }else{Valid.pindah(evt, BtnSimpan, BtnHapus);}
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if(tbObat.getSelectedRow()!= -1){
            if(Sequel.queryu2tf("delete from data_klpcm where tgl_setor=? and no_rawat=?",2,new String[]{
                tbObat.getValueAt(tbObat.getSelectedRow(),0).toString(),tbObat.getValueAt(tbObat.getSelectedRow(),1).toString()
            })==true){
                tampil();
                emptTeks();
            }else{
                JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            }
        }            
            
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
       // iscombo();
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"pasien");
        }else{   
            if(ID.getSelectedItem().equals("TIDAK") && Medis.getSelectedItem().equals("TIDAK") && Intgrs.getSelectedItem().equals("TIDAK")){
                       JOptionPane.showMessageDialog(null,"Maaf, Pilih IYA salah satu KLPCM Pasien Untuk Ganti.!");
            }else{
                Sequel.mengedit("data_klpcm","tgl_setor=? and no_rawat=?","tgl_setor=?,no_rawat=?,tanggal_masuk=?,jbayar=?,dokter=?,ID=?,Medis=?,intgrs=?,kep=?,IC=?,Lop=?,Keterangan=?,StatusDRM=?,tgl_diserahkan=?,tgl_diterima=?,LTL=?",18,new String[]{
                        Valid.SetTgl(Tanggal.getSelectedItem()+""),TNoRw.getText(),Valid.SetTgl(Tanggalkrs.getSelectedItem()+""),JBayar.getText(),
                            Dokter.getText(),ID.getSelectedItem().toString(),Medis.getSelectedItem().toString(),Intgrs.getSelectedItem().toString(),
                            Kep.getSelectedItem().toString(),IC.getSelectedItem().toString(),LOp.getSelectedItem().toString(),Keterangan.getText(),
                            Status.getText(),Valid.SetTgl(tgldiserahkan.getSelectedItem()+""),Valid.SetTgl(tglditerima.getSelectedItem()+""),LTL.getSelectedItem().toString(),
                            tbObat.getValueAt(tbObat.getSelectedRow(),0).toString(),tbObat.getValueAt(tbObat.getSelectedRow(),1).toString()
                });
                if(tabMode.getRowCount()!=0){tampil();}
                emptTeks();
            }
        }
        
}//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnPrint);
        }
}//GEN-LAST:event_BtnEditKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnEdit,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(! TCari.getText().trim().equals("")){
            BtnCariActionPerformed(evt);
        }
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            BtnBatal.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Map<String, Object> param = new HashMap<>(); 
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());   
                param.put("tanggal1",Valid.SetTgl(DTPCari1.getSelectedItem()+""));   
                param.put("tanggal2",Valid.SetTgl(DTPCari2.getSelectedItem()+""));   
                param.put("parameter","%"+TCari.getText().trim()+"%");   
                param.put("logo",Sequel.cariGambar("select logo from setting")); 
                Valid.MyReport("rptDataKLPCM.jasper",param,"::[ Data KLPCM Pasien ]::");
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            tampil();
            TCari.setText("");
        }else{
            Valid.pindah(evt, BtnCari, TPasien);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void TNoRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRMKeyPressed
        // Valid.pindah(evt, TNm, BtnSimpan);
}//GEN-LAST:event_TNoRMKeyPressed

    private void tbObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbObatMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbObatMouseClicked

    private void tbObatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbObatKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbObatKeyPressed

    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
        isForm();
    }//GEN-LAST:event_ChkInputActionPerformed

    private void KamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KamarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KamarKeyPressed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
       // iscombo();      
    }//GEN-LAST:event_IDActionPerformed

    private void MedisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedisActionPerformed
      //  iscombo();
    }//GEN-LAST:event_MedisActionPerformed

    private void IntgrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntgrsActionPerformed
     //  iscombo();
    }//GEN-LAST:event_IntgrsActionPerformed

    private void ICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ICActionPerformed

    private void KepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KepActionPerformed

    private void LOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOpActionPerformed

    private void TanggalkrsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalkrsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TanggalkrsKeyPressed

    private void KeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeteranganKeyPressed

    private void StatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StatusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusKeyPressed

    private void DokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DokterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DokterKeyPressed

    private void JBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBayarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBayarKeyPressed

    private void JBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBayarActionPerformed

    private void LTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LTLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LTLActionPerformed

    private void tglditerimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tglditerimaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglditerimaKeyPressed

    private void TanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TanggalKeyPressed

    private void tgldiserahkanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgldiserahkanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgldiserahkanKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgKLPCM dialog = new DlgKLPCM(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.TextBox Dokter;
    private widget.PanelBiasa FormInput;
    private widget.ComboBox IC;
    private widget.ComboBox ID;
    private widget.ComboBox Intgrs;
    private widget.TextBox JBayar;
    private widget.TextBox Kamar;
    private widget.ComboBox Kep;
    private widget.TextBox Keterangan;
    private widget.Label LCount;
    private widget.ComboBox LOp;
    private widget.ComboBox LTL;
    private widget.ComboBox Medis;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private widget.TextBox Status;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.Tanggal Tanggal;
    private widget.Tanggal Tanggalkrs;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel12;
    private widget.Label jLabel13;
    private widget.Label jLabel14;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel28;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private widget.Label jLabel9;
    private javax.swing.JPanel jPanel3;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.Table tbObat;
    private widget.Tanggal tgldiserahkan;
    private widget.Tanggal tglditerima;
    // End of variables declaration//GEN-END:variables

//    private void iscombo(){
//    if (Minimal.getSelectedItem().equals("IYA")){
//         Minimal.setEnabled(true);
//         Partial.setEnabled(false);
//         Total.setEnabled(false);
//        }else if(Partial.getSelectedItem().equals("IYA")){
//         Minimal.setEnabled(false);
//         Partial.setEnabled(true);
//         Total.setEnabled(false);
//        }else if(Total.getSelectedItem().equals("IYA")){
//         Minimal.setEnabled(false);
//         Partial.setEnabled(false);
//         Total.setEnabled(true);
//        }else{
//         Minimal.setEnabled(true);
//         Partial.setEnabled(true);
//         Total.setEnabled(true);
//        }  
//    }
    
    public void tampil() {
       // iscombo();
        Valid.tabelKosong(tabMode);
        try{
            ps=koneksi.prepareStatement(
                    "select data_klpcm.tgl_setor,data_klpcm.no_rawat,data_klpcm.tanggal_masuk,reg_periksa.no_rkm_medis,pasien.nm_pasien,kamar_inap.kd_kamar,"+
                    "data_klpcm.jbayar,data_klpcm.dokter,data_klpcm.ID,data_klpcm.Medis,data_klpcm.Intgrs,data_klpcm.Kep,"+
                    "data_klpcm.IC,data_klpcm.LOp,data_klpcm.Keterangan,data_klpcm.StatusDRM,data_klpcm.tgl_diserahkan,data_klpcm.tgl_diterima,data_klpcm.LTL"+
                    " from data_klpcm inner join reg_periksa "+
                    "inner join pasien inner join kamar_inap  on data_klpcm.no_rawat=kamar_inap.no_rawat "+
                    "and data_klpcm.no_rawat=reg_periksa.no_rawat and reg_periksa.no_rkm_medis=pasien.no_rkm_medis where "+
                    "data_klpcm.tgl_setor between ? and ? and data_klpcm.no_rawat like ? or "+
                    "data_klpcm.tgl_setor between ? and ? and reg_periksa.no_rkm_medis like ? or "+
                    "data_klpcm.tgl_setor between ? and ? and pasien.nm_pasien like ? order by data_klpcm.tgl_setor "); 
            try {
                
                ps.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                ps.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                ps.setString(3,"%"+TCari.getText()+"%");
                ps.setString(4,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                ps.setString(5,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                ps.setString(6,"%"+TCari.getText()+"%");
                ps.setString(7,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                ps.setString(8,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                ps.setString(9,"%"+TCari.getText()+"%");
                
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new String[]{
                        rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),rs.getString(9),
                        rs.getString(10),rs.getString(11),rs.getString(12),
                        rs.getString(13),rs.getString(14),rs.getString(15),
                        rs.getString(16),rs.getString(17),rs.getString(18),
                        rs.getString(19)
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
        int b=tabMode.getRowCount();
        LCount.setText(""+b);
    }

    public void emptTeks() {
        Tanggalkrs.requestFocus();
        Tanggal.setDate(new Date());
        tgldiserahkan.setDate(new Date());
        tglditerima.setDate(new Date());
        Keterangan.setText("");
        Status.setText("");
        ID.setSelectedIndex(0);
        Medis.setSelectedIndex(0);
        Intgrs.setSelectedIndex(0);
        Kep.setSelectedIndex(0);
        IC.setSelectedIndex(0);
        LOp.setSelectedIndex(0);
        LTL.setSelectedIndex(0);
    }

   

    private void getData() {
        if(tbObat.getSelectedRow()!= -1){
            TNoRw.setText(tbObat.getValueAt(tbObat.getSelectedRow(),1).toString());
            Valid.SetTgl(Tanggalkrs,tbObat.getValueAt(tbObat.getSelectedRow(),2).toString());
            TNoRM.setText(tbObat.getValueAt(tbObat.getSelectedRow(),3).toString());
            TPasien.setText(tbObat.getValueAt(tbObat.getSelectedRow(),4).toString());
            Kamar.setText(tbObat.getValueAt(tbObat.getSelectedRow(),5).toString());
            JBayar.setText(tbObat.getValueAt(tbObat.getSelectedRow(),6).toString());
            Dokter.setText(tbObat.getValueAt(tbObat.getSelectedRow(),7).toString());
            Valid.SetTgl(Tanggal,tbObat.getValueAt(tbObat.getSelectedRow(),0).toString());
            ID.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),8).toString());
            Medis.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),9).toString());
            Intgrs.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),10).toString());
            Kep.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),11).toString());
            IC.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),12).toString());
            LOp.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),13).toString());
            Keterangan.setText(tbObat.getValueAt(tbObat.getSelectedRow(),14).toString());
            Status.setText(tbObat.getValueAt(tbObat.getSelectedRow(),15).toString());
            Valid.SetTgl(tgldiserahkan,tbObat.getValueAt(tbObat.getSelectedRow(),16).toString());
            Valid.SetTgl(tglditerima,tbObat.getValueAt(tbObat.getSelectedRow(),17).toString());
            LTL.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(),18).toString());
        }
    }

    private void isRawat() {
         Sequel.cariIsi("select no_rkm_medis from reg_periksa where no_rawat='"+TNoRw.getText()+"' ",TNoRM);
    }

    private void isPsien() {
        Sequel.cariIsi("select nm_pasien from pasien where no_rkm_medis='"+TNoRM.getText()+"' ",TPasien);
    }
    
    public void setNoRm(String norwt, Date tgl1, Date tgl2) {
        TNoRw.setText(norwt);
        TCari.setText(norwt);
        DTPCari1.setDate(tgl1);
        DTPCari2.setDate(tgl2);
        isRawat();
        isPsien();              
        ChkInput.setSelected(true);
        isForm();
        Sequel.cariIsi("select kd_kamar from kamar_inap where no_rawat=? order by tgl_masuk desc limit 1",Kamar,TNoRw.getText());
        Valid.SetTgl(Tanggalkrs,Sequel.cariIsi("select tgl_masuk from kamar_inap where no_rawat=? order by tgl_masuk desc limit 1",TNoRw.getText()));
        Sequel.cariIsi("select penjab.png_jawab from reg_periksa inner join penjab on reg_periksa.kd_pj = penjab.kd_pj where no_rawat=? ",JBayar,TNoRw.getText());
        Sequel.cariIsi("select dokter.nm_dokter from dokter inner join reg_periksa on dokter.kd_dokter = reg_periksa.kd_dokter where no_rawat=? ",Dokter,TNoRw.getText());
       
    }
    
    private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,230));
            FormInput.setVisible(true);      
            ChkInput.setVisible(true);
        }else if(ChkInput.isSelected()==false){           
            ChkInput.setVisible(false);            
            PanelInput.setPreferredSize(new Dimension(WIDTH,20));
            FormInput.setVisible(false);      
            ChkInput.setVisible(true);
        }
    }
    
    public void isCek(){
        BtnSimpan.setEnabled(akses.getkunjungan_ralan());
        BtnHapus.setEnabled(akses.getkunjungan_ralan());
        BtnPrint.setEnabled(akses.getkunjungan_ralan());
    }

   
}

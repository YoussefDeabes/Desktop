/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPage;

import static PDFIMG.PDF2IMG.convertToIMG;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author salah Ben Atwa
 */
public class PDFToImagePanel extends javax.swing.JPanel {

    /**
     * Creates new form PDFToImagePanel
     */
    public PDFToImagePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabell1 = new javax.swing.JLabel();
        jButtonn1 = new javax.swing.JButton();
        pdfstat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabell1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabell1.setForeground(new java.awt.Color(0, 0, 102));
        jLabell1.setText("Select Your PDF");
        add(jLabell1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jButtonn1.setBackground(new java.awt.Color(204, 51, 0));
        jButtonn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PDF toImgs 48.png"))); // NOI18N
        jButtonn1.setToolTipText("Select PDF File");
        jButtonn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonn1ActionPerformed(evt);
            }
        });
        add(jButtonn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 50));

        pdfstat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pdfstat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BAR.gif"))); // NOI18N
        add(pdfstat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 10));
        pdfstat.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Convert PDF into Images");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white with blue.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonn1ActionPerformed
        pdfstat.setVisible(true);

        try {
            FileDialog PdfFilePath = new FileDialog(new java.awt.Frame(), "select PDF", FileDialog.LOAD);
            PdfFilePath.setVisible(true);
            PdfFilePath.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));
           
            String PDFpath = PdfFilePath.getDirectory() + "\\" + PdfFilePath.getFile();
            if (PDFpath != null) {
                String d = PDFpath.substring(PDFpath.lastIndexOf("."));
                d = d.toLowerCase();
                if (d.equals(".pdf")) {
                    FileDialog SaveDjVu = new FileDialog(new java.awt.Frame(), "Save Images", FileDialog.SAVE);
                    SaveDjVu.setVisible(true);
                    String path = SaveDjVu.getDirectory() + SaveDjVu.getFile();
                    if (path != null && SaveDjVu.getFile() != null) {
                        convertToIMG(PDFpath, path, 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "File selected is not PDF");
                    PDFpath = null;
                }
            } else {
            }
        } catch (Exception ex) {
        } finally {
            pdfstat.setVisible(false);

        }


    }//GEN-LAST:event_jButtonn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabell1;
    private javax.swing.JLabel pdfstat;
    // End of variables declaration//GEN-END:variables
}

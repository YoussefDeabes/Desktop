/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPage;

import PDF2DjVu.PDF2DjVu;
import com.lizardtech.djview.frame.DjvuStart;
import static com.lizardtech.djview.frame.DjvuStart.curropen;
import static com.lizardtech.djview.frame.DjvuStart.name_url;
import static com.lizardtech.djview.frame.DjvuStart.openBookInNewTab;
import static com.lizardtech.djview.frame.DjvuStart.tabbedPane;
import static com.lizardtech.djview.frame.DjvuStart.url_name;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author salah Ben Atwa
 */
public class PDF2DjVuPanel extends javax.swing.JPanel {

    /**
     * Creates new form PDF2DjVuPanel
     */
    public PDF2DjVuPanel() {
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

        jButton1 = new javax.swing.JButton();
        bar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PDFtoDJ 48.png"))); // NOI18N
        jButton1.setToolTipText("Select PDF File");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 50));

        bar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BAR.gif"))); // NOI18N
        add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 10));
        bar.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Select Your PDF");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Convert PDF into Djvu");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white with blue.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));
    }// </editor-fold>//GEN-END:initComponents
       String fullPDF = null;
    File le = null;

       // check name of book is arabic or english 
    public static boolean isProbablyArabic(String s) {
        for (int i = 0; i < s.length();) {
            int c = s.codePointAt(i);
            if (c >= 0x0600 && c <= 0x06E0) {
                return true;
            }
            i += Character.charCount(c);
        }
        return false;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        bar.setVisible(true);
        try {

            FileDialog PdfFile = new FileDialog(new java.awt.Frame(), "select PDF", FileDialog.LOAD);
            PdfFile.setVisible(true);
             PdfFile.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));

            fullPDF = PdfFile.getDirectory() + PdfFile.getFile();

            if (fullPDF != null) {
                String d = fullPDF.substring(fullPDF.lastIndexOf("."));
                d = d.toLowerCase();

                //check book is pdf 
                if (d.equals(".pdf")) {
                    String pathpdf = "\"" + fullPDF + "\""; // skip spaces 
                    String namedjvu = fullPDF.substring(fullPDF.lastIndexOf("\\") + 1, fullPDF.lastIndexOf(".")).replaceAll(" ", "%20");
                    if (isProbablyArabic(namedjvu)) {
                        PDF2DjVu.PDF2DjVu(pathpdf, "C:\\DjVu++Task\\DjVuNew", 1);
                        le = new File("C:\\DjVu++Task\\DjVuNew.djvu");
                    } else if (!isProbablyArabic(namedjvu)) {
                        PDF2DjVu.PDF2DjVu(pathpdf, "C:\\DjVu++Task\\"+namedjvu, 1);
                        le = new File("C:\\DjVu++Task\\"+namedjvu+".djvu");
                    }

                    String url;
                    url = "" + le.toURI();
                    url = url.substring(5, url.length());
                    String name = le.getName();

                    if (!curropen.contains(name)) {
                        name_url.put(name, url);
                        url_name.put(url, name);
                        curropen.add(name);
                        openBookInNewTab(url, name);
                        DjvuStart.unsavedbook.add(url);

                    } else if (curropen.contains(name)) {
                        tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(name));
                    } else {
                    }

                    ////////////////////         
                } else {
                    bar.setVisible(false);
                    JOptionPane.showMessageDialog(null, "File selected not pdf  ");
                    fullPDF = null;
                }

            }
        } catch (Exception ex) {
        } finally {
            bar.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

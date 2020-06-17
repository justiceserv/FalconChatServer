/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package falconserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author strea
 */
public class Mainform extends javax.swing.JFrame {
    public static ArrayList<String> logs = new ArrayList();
    public static int currentEntry;

    public static ArrayList<String> temporaryMessages = new ArrayList();
    static Socket sl;
    static ServerSocket ss;

    public static ArrayList<String> onlineUsers = new ArrayList();
    public static ArrayList<ServerSocket> serverSockets = new ArrayList();
    public static ArrayList<Socket> sockets = new ArrayList();
    public static int currentPortNumber = 1001;

    /**
     * Creates new form Mainform
     */
    public Mainform() {
        initComponents();
        jList1.setModel(LoginDB.usersModel);
        jRaw.setText(String.join("\n", logs));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jUsername = new javax.swing.JTextField();
        jPW = new javax.swing.JPasswordField();
        jEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jaddbtn = new javax.swing.JButton();
        jmodifybtn = new javax.swing.JButton();
        jdeletebtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jRaw = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jOnline = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Server");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, 150, 470));

        jLabel1.setText("Total Users: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Online Users:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        getContentPane().add(jUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 160, -1));
        getContentPane().add(jPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 160, -1));
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 160, -1));

        jLabel3.setText("Username:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jLabel4.setText("Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jLabel5.setText("Email:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jaddbtn.setText("Add User");
        jaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaddbtnActionPerformed(evt);
            }
        });
        getContentPane().add(jaddbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 160, -1));

        jmodifybtn.setText("Modify User");
        jmodifybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmodifybtnActionPerformed(evt);
            }
        });
        getContentPane().add(jmodifybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 160, -1));

        jdeletebtn.setText("Delete User");
        jdeletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(jdeletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 160, -1));

        jRaw.setColumns(20);
        jRaw.setRows(5);
        jScrollPane3.setViewportView(jRaw);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 220, 470));

        jLabel6.setText("Raw Request:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        jOnline.setColumns(20);
        jOnline.setRows(5);
        jScrollPane4.setViewportView(jOnline);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 170, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaddbtnActionPerformed
        try
        {
            if(LoginDB.findUser(jUsername.getText()) == false)
            {
                LoginDB.addUser(jUsername.getText(), getMd5(new String(jPW.getPassword())), jEmail.getText());
                jList1.setModel(LoginDB.usersModel);
            }
            else if(LoginDB.findUser(jUsername.getText()) == true)
            {
                JOptionPane.showMessageDialog(null, "That Username is Already Taken.");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "InfoBox: ERROR", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jaddbtnActionPerformed

    private void jmodifybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmodifybtnActionPerformed

    }//GEN-LAST:event_jmodifybtnActionPerformed

    private void jdeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeletebtnActionPerformed
        try
        {
            int n = JOptionPane.showConfirmDialog(this, "Are you Sure?","Confirmation",JOptionPane.OK_CANCEL_OPTION);
            if (n == 0)
            {
                LoginDB.deleteUser(currentEntry);
                jList1.setModel(LoginDB.usersModel);
                jUsername.setText("");
                jPW.setText("");
                jEmail.setText("");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "InfoBox: ERROR", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jdeletebtnActionPerformed

    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
        // TODO add your handling code here:
        currentEntry = jList1.getSelectedIndex();
        User user = LoginDB.users.get(currentEntry);
        jUsername.setText(user.username);
        jPW.setText(user.password);
        jEmail.setText(user.email);
    }//GEN-LAST:event_jList1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new Mainform().setVisible(true);

        Thread loginThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        ss = new ServerSocket(1000);
                        System.out.println("[server] binding!");
                        sl = ss.accept();
                        BufferedReader br = new BufferedReader(new InputStreamReader(sl.getInputStream()));
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sl.getOutputStream()));
                        try {
                            String loginrequest = br.readLine();
                            System.out.println(loginrequest);
                            String[] arguments = loginrequest.split("#", 0);
                            String outmessage = "";
                            if(loginrequest.startsWith("L#")) {
                                if(LoginDB.login(arguments[1], arguments[2]) == true) {
                                    makeChatThread().start();
                                    outmessage = "L#" + arguments[1] + "#success#" + currentPortNumber;
                                    logs.add(outmessage);
                                    jRaw.setText(String.join("\n", logs));
                                    onlineUsers.add(arguments[1]);
                                    jOnline.setText(String.join("\n", onlineUsers));
                                } else {
                                    outmessage = "L#" + arguments[1] + "#failed#";
                                    logs.add(outmessage);
                                    jRaw.setText(String.join("\n", logs));
                                }
                                bw.write(outmessage);
                                bw.newLine();
                                bw.flush();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw e;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Mainform.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    } finally {
                        try {
                            if (ss != null && !ss.isClosed()) {
                                ss.close();
                                System.out.println("[server] closing!");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        loginThread.start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        System.out.println("temporaryMessages: " + temporaryMessages);
                        for (int i = 0; i < temporaryMessages.size(); ++i) {
                            String message = temporaryMessages.get(i);
                            String[] arguments = message.split("#");
                            int userIndex = onlineUsers.indexOf(arguments[2]);
                            if(LoginDB.findUser(arguments[2]) == false)
                            {
                                int userCF = onlineUsers.indexOf(arguments[1]);
                                Socket socket = sockets.get(userCF);
                                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                                bw.write("CF#"+arguments[1]+"#"+arguments[2]+"#");
                                bw.newLine();
                                bw.flush();
                                System.out.println("CF#"+arguments[1]+"#"+arguments[2]+"#");
                                temporaryMessages.remove(i--);
                            }
                            else if (userIndex > -1) 
                            {
                                Socket socket = sockets.get(userIndex);
                                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                                bw.write(message);
                                bw.newLine();
                                bw.flush();
                                temporaryMessages.remove(i--);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static Thread makeChatThread() {
        return new Thread(new Runnable() {
            public void run() {
                ServerSocket serverSocket = null;
                Socket socket = null;
                while (true) {
                    try {
                        serverSocket = new ServerSocket(currentPortNumber);
                        serverSockets.add(serverSocket);
                        System.out.println("[server] chat socket binding! portnumber: " + (currentPortNumber++));
                        socket = serverSocket.accept();
                        sockets.add(socket);
                        socket.setSoTimeout(300000);
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (true) {
                            try {
                                String request = br.readLine();
                                System.out.println(request);
                                logs.add(request);
                                jRaw.setText(String.join("\n", logs));
                                String[] arguments = request.split("#", 0);
                                if (request.startsWith("C#")) 
                                {
                                    boolean isRegistered = false;
                                    for (int i = 0; i < LoginDB.users.size(); ++i) {
                                        if (arguments[1].equals(LoginDB.users.get(i).username)) {
                                            isRegistered = true;
                                        }
                                    }
                                    if (isRegistered) 
                                    {
                                        temporaryMessages.add(request);
                                    }
                                } 
                                else if (request.startsWith("LO#")) {
                                    try {
                                        System.out.println("[server] logout " + arguments[1]);
                                        onlineUsers.remove(arguments[1]);
                                        jOnline.setText(String.join("\n", onlineUsers));
                                        sockets.remove(socket);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        try {
                                            if (socket != null && !socket.isClosed()) {
                                                socket.close();
                                                break;
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                try {
                                    if (socket != null && !socket.isClosed()) {
                                        int index = sockets.indexOf(socket);
                                        onlineUsers.remove(index);
                                        jOnline.setText(String.join("\n", onlineUsers));
                                        sockets.remove(socket);
                                        socket.close();
                                        break;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Mainform.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    } finally {
                        try {
                            if (serverSocket != null && !serverSocket.isClosed()) {
                                int index = sockets.indexOf(socket);
                                onlineUsers.remove(index);
                                jOnline.setText(String.join("\n", onlineUsers));
                                sockets.remove(socket);
                                serverSocket.close();
                                System.out.println("[server] closing!");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
public static String getMd5(String input) 
    { 
        try { 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private static javax.swing.JTextArea jOnline;
    private javax.swing.JPasswordField jPW;
    public static javax.swing.JTextArea jRaw;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jUsername;
    private javax.swing.JButton jaddbtn;
    private javax.swing.JButton jdeletebtn;
    private javax.swing.JButton jmodifybtn;
    // End of variables declaration//GEN-END:variables
}
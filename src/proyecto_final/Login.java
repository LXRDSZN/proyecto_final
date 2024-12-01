package proyecto_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Login extends javax.swing.JFrame {
    //Variables para el inicio de sesion
    String password = "admin";
    String user = "admin";
    //variable inicial para el conteo de inicio de sesion 
    private int intentosFallidos = 0;

    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_login = new javax.swing.JPanel();
        usuario_label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        usuario_texto = new javax.swing.JTextField();
        contraseña_label = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        contraseña_texto = new javax.swing.JTextField();
        boton_iniciar_sesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_login.setBackground(new java.awt.Color(255, 255, 255));
        Panel_login.setForeground(new java.awt.Color(255, 255, 255));
        Panel_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario_label.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        usuario_label.setForeground(new java.awt.Color(0, 0, 0));
        usuario_label.setText("Usuario");
        Panel_login.add(usuario_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 43, 70, 25));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 255));
        Panel_login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 110, 280, 20));

        usuario_texto.setBackground(new java.awt.Color(255, 255, 255));
        usuario_texto.setForeground(new java.awt.Color(0, 0, 0));
        usuario_texto.setToolTipText("");
        usuario_texto.setActionCommand("<Not Set>");
        usuario_texto.setBorder(null);
        usuario_texto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usuario_texto.setName(""); // NOI18N
        usuario_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_textoActionPerformed(evt);
            }
        });
        Panel_login.add(usuario_texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 74, 270, 50));

        contraseña_label.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        contraseña_label.setForeground(new java.awt.Color(0, 0, 0));
        contraseña_label.setText("Contraseña");
        Panel_login.add(contraseña_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 171, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 255));
        Panel_login.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 270, 20));

        contraseña_texto.setBackground(new java.awt.Color(255, 255, 255));
        contraseña_texto.setBorder(null);
        contraseña_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseña_textoActionPerformed(evt);
            }
        });
        Panel_login.add(contraseña_texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 260, 50));

        boton_iniciar_sesion.setBackground(new java.awt.Color(102, 153, 255));
        boton_iniciar_sesion.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        boton_iniciar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        boton_iniciar_sesion.setText("Iniciar sesion");
        boton_iniciar_sesion.setBorder(null);
        boton_iniciar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_iniciar_sesionActionPerformed(evt);
            }
        });
        Panel_login.add(boton_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 178, 38));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_final/Images/examen.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        Panel_login.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 360, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Boton para iniciar sesion
    private void boton_iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_iniciar_sesionActionPerformed
    // Obtener los textos de los campos de usuario y contraseña
    String usuario = usuario_texto.getText();
    String contraseña = contraseña_texto.getText();

    // Verificar si los campos están vacíos
    if (usuario.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validar las credenciales
    if (usuario.equals(user) && contraseña.equals(password)) {
        JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        Panel PanelPrincipal = new Panel();
        dispose();
        PanelPrincipal.setVisible(true);
         // Crear un temporizador que muestre el mensaje después de 2 segundos
        Timer timer = new Timer(500, new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar el mensaje después de que transcurran 2 segundos
            JOptionPane.showMessageDialog(PanelPrincipal, "Selecciona las materias y contesta las preguntas correctamente", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
        }
    });
    
    timer.setRepeats(false); // Solo se ejecutará una vez
    timer.start(); // Iniciar el temporizador
    } else {
        intentosFallidos++;
        if (intentosFallidos >= 3) {
            JOptionPane.showMessageDialog(this, "Has excedido el número de intentos. El programa se cerrará.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); // Cerrar el programa
        } else {
            JOptionPane.showMessageDialog(this, "Datos incorrectos. Intenta nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_boton_iniciar_sesionActionPerformed
    //Campo para ingresar el texto en usuario 
    private void usuario_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_textoActionPerformed

    }//GEN-LAST:event_usuario_textoActionPerformed
    //Campo para ingresar texto en contraseña 
    private void contraseña_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseña_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseña_textoActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_login;
    private javax.swing.JButton boton_iniciar_sesion;
    private javax.swing.JLabel contraseña_label;
    private javax.swing.JTextField contraseña_texto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel usuario_label;
    private javax.swing.JTextField usuario_texto;
    // End of variables declaration//GEN-END:variables
}

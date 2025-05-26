package edu.mokpo.myproject;

import javax.swing.*;

public class LoginForm extends javax.swing.JFrame {
    public LoginForm() {
        initComponents(); // NetBeans GUI Designer 사용
    }

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {
        String id = txt_id.getText();
        String pwd = txt_pwd.getText();

        MemberDAO dao = new MemberDAO();
        MemberDTO dto = dao.search(id, pwd);

        if (dto != null) {
            JOptionPane.showMessageDialog(this, dto.getName() + "님 로그인 성공!");
        } else {
            JOptionPane.showMessageDialog(this, "로그인 실패: ID/PW 확인");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_id = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        lbl_pwd = new javax.swing.JLabel();
        txt_pwd = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_id.setText("아이디");

        btn_login.setText("로그인");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginmemberJoin(evt);
            }
        });

        lbl_pwd.setText(" 패스워드");

        txt_pwd.setColumns(20);
        txt_pwd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txt_id.setColumns(20);
        txt_id.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbl_pwd)
                            .addGap(18, 18, 18)
                            .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(lbl_id)
                            .addGap(33, 33, 33)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btn_login)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pwd)
                    .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(btn_login)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginmemberJoin(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginmemberJoin

    }//GEN-LAST:event_btn_loginmemberJoin

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_pwd;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_pwd;
    // End of variables declaration//GEN-END:variables

}
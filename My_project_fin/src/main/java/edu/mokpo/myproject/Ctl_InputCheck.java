/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mokpo.myproject;

/**
 *
 * @author user
 */
public class Ctl_InputCheck {
    public boolean idCheck(String id) {
        if (id == null || id.isEmpty()) return false;
        int min = 5, max = 20;
        if (id.length() < min || id.length() > max) return false;

        for (char c : id.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
}


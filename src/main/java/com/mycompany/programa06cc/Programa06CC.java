/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.programa06cc;

/**
 *
 * @author ruben
 */
public class Programa06CC {

    public static void main(String[] args) {
        
        DAOVenta dao = new DAOVenta();        
        Venta empleado = new Venta();
        empleado.setClave(1);
        empleado.setNombre("Prueba1");
        empleado.setDireccion("av 1");
        empleado.setTelefono("1234");
        
        
        dao.create(empleado);
        //dao.delete(empleado.getClave());
        //List<Empleado> lstRes2= dao.findAll();//prueba findAll
        //for (Venta empleado lstRes2)//prueba de findAll
        //dao.findAll(empleado);
        //dao.findByID();
        
        
        
        
        System.out.println("Hello World!");
    }
}

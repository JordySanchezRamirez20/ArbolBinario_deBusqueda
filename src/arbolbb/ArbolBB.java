/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbb;


import javax.swing.JOptionPane;
import static arbolbb.ArbolBbusqueda.Salida;
import static arbolbb.ArbolBbusqueda.Sa;

public class ArbolBB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBbusqueda c = new ArbolBbusqueda();
        String op;
        int opcion;
        do{
            op = JOptionPane.showInputDialog(null,"\n\tMenú Principal\n\n"
                    + "\t1. Insertar Dato - Árbol\n"
                    + "\t2. Recorrido Pre-Orden\n"
                    + "\t3. Recorrido Post-Orden\n"
                    + "\t4. Recorrido In-Orden\n"
                    + "\t5. Buscar Dato en el Árbol\n"
                    + "\t6. Contar Nodos en el Árbol\n"
                    + "\t7. Sumar Nodos en el Árbol\n"
                    + "\t8. Calcular Niveles en el Árbol\n"
                    + "\t9. Buscar el Mayor Valor en los Nodos del Árbol\n"
                    + "\t10. Buscar el Menor Valor en los Nodos del Árbol\n"
                    + "\t11. Eliminar Datos en el Árbol\n"
                    + "\t12. Imprimir el Valor de la Raiz del Árbol\n"
                    + "\t13. Modificar el Dato del Árbol\n\n"
                    + "\t0. Salir\n"
                    + "\n\t Seleccione una opción","Árbol Binario de Búsqueda",JOptionPane.INFORMATION_MESSAGE);
            if("1".equals(op) || "2".equals(op) || "3".equals(op) || "4".equals(op) || "5".equals(op) || "0".equals(op) || "6".equals(op) || "7".equals(op) || "8".equals(op) || "9".equals(op) || "10".equals(op) || "11".equals(op) || "12".equals(op) || "13".equals(op)){
                opcion = Integer.parseInt(op);
            }
            else
                if(op == null){
                    opcion = 0;
                }
                else{
                    opcion = -1;
                }
                switch(opcion){
                    case 1:
                        c.InsertarNodo();
                        break;
                    case 2:
                        if(c.Vacio() == false){
                            Salida = "\n\tPreOrden\n";
                            c.PreOrden(c.Raiz);
                            JOptionPane.showMessageDialog(null,"\n\t" + Salida,"Pre Orden",1);
                        }
                        break;
                    case 3:
                        if(c.Vacio() == false){
                            Salida = "\n\tPostOrden\n";
                            c.PostOrden(c.Raiz);
                            JOptionPane.showMessageDialog(null,"\n\t" + Salida,"Post Orden",1);
                        }
                        break;
                    case 4:
                        if(c.Vacio() == false){
                            Salida = "\n\tInOrden\n";
                            c.InOrden(c.Raiz);
                            JOptionPane.showMessageDialog(null,"\n\t" + Salida,"In Orden",1);
                        }
                        break;
                    case 5: 
                        if(c.Vacio() == false){
                            c.Buscar();
                        }
                        break;
                    case 6:
                        if(c.Vacio() == false){
                            Sa = 0;
                             c.ContarN(c.Raiz);
                            JOptionPane.showMessageDialog(null,"\n\tLa cantidad de nodos en el arbol son : "+ Sa,"Cantidad de nodos en arbol",1);
                        }
                        break;
                    case 7:
                        if(c.Vacio() == false){
                            Sa = 0;
                            c.SumaNodos(c.Raiz);
                            JOptionPane.showMessageDialog(null,"\n\tLa suma de los nodos es: " + Sa,"Suma de nodos",1);
                        }
                        break;
                    case 8:
                        if(c.Vacio() == false){
                           //Se le pone 1 para que lleve la cuenta de que la raíz ya existe.
                           Sa = 0;
                           c.Niveles(c.Raiz,1);
                           JOptionPane.showMessageDialog(null,"\n\tLos niveles del arbol son: " + Sa,"Niveles del arbol",1);
                        }
                        break;
                    case 9:
                        if(c.Vacio() == false){
                            c.MayorValor();
                        }
                        break;
                    case 10:
                        if(c.Vacio() == false){
                            c.MenorValor();
                        }
                        break;
                    case 11:
                        if(c.Vacio() == false){
                            int datoNuevo;
                            datoNuevo = Integer.parseInt(JOptionPane.showInputDialog(null,"\n\tIntroduce Dato: ","Eliminar dato en el arbol binario",3));
                            if(c.EliminarNodo(datoNuevo) == false){
                                JOptionPane.showMessageDialog(null,"El Nodo - " + datoNuevo + " - No se encuentra en el arbol","Eliminar Dato en el arbol binario",0);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"\n\tEl Nodo - " + datoNuevo + " - Ha Sido eliminado del arbol","Eliminar dato en el arbol",1);
                            }
                        }
                        break;
                    case 12:
                        if(c.Vacio() == false){
                            c.IRaiz();
                        }
                        break;
                    case 13:
                        if(c.Vacio() == false){
                            c.Modificar();
                        }
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null,"\n\tHasta luego","Salir",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"\n\tOpción Inválida","Error",JOptionPane.WARNING_MESSAGE);
                }
        }while(opcion != 0);
        
    }
    
}


package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mi_paquete.Alumno;


public class SProcesar extends HttpServlet 
{

    private Alumno dato[]=new Alumno[10]; 
    int cont=0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
           if(request.getParameter("btnRegistrar")!=null)
            {
                dato[cont]=new Alumno();
                dato[cont].setMatricula(request.getParameter("txfMatricula"));
                dato[cont].setNombre(request.getParameter("txfNombre"));
                dato[cont].setApellidoP(request.getParameter("txfApellidoP"));
                dato[cont].setApellidoM(request.getParameter("txfApellidoM"));
                dato[cont].setDdi(Integer.parseInt(request.getParameter("txfDDI")));
                dato[cont].setDwi(Integer.parseInt(request.getParameter("txfDWI")));
                dato[cont].setEcbd(Integer.parseInt(request.getParameter("txfECBD")));
   
                cont++;
               
                out.print("<table border='1'>");
                   out.print("<thead>"+
                   "<tr>"+
                    "<th>"+"Matricula"+"</th>"
                    +"<th>"+"Nombre completo"+"</th>"
                    +"<th>"+"ddi"+"</th>"
                    +"<th>"+"dwi"+"</th>"
                    +"<th>"+"ecbd"+"</th>"
                    +"<th>"+"Promedio"+"</th>"
                    +"</tr>"
                    +"</thead>");
               
     
                out.print("<link rel='stylesheet' href='css/estilos.css'>"); 
                out.print("<h1>"+"Registros!"+"</h1>"+"<tbody>");
               
                     for(int i=0; i<cont; i++)
                        {
                           out.print("<tr>"); 
                           out.print("<td>"+dato[i].getMatricula()+"</td>");
                           out.print("<td>"+dato[i].getNombre()+" "+dato[i].getApellidoP()+" "+dato[i].getApellidoM()+"</td>");
                           out.print("<td>"+dato[i].getDdi()+"</td>");
                           out.print("<td>"+dato[i].getDwi()+"</td>");
                           out.print("<td>"+dato[i].getEcbd()+"</td>");
                           out.print("<td>"+dato[i].getProm()+"</td>");
                           out.print("</tr>"); 
                        }
                   
               out.print("</tbody>");
            out.print("</table>");
          
                
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

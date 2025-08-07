/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerPkg;

import businesslayer.UserBusinessLogic;
import businesslayer.ValidationException;
import businesslayer.VehicleBusinessLogic;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import transferobjects.UserDTO;
import transferobjects.VehicleDTO;

/**FrontController.java
 * This servlet is responsible for processing login functionality and dispatching to other related servlets to display the main Public Fleet UI.
 * @author Patricia Sunday
 * @version V1
 * @see businesslayer
 * @since Apache NetBeans IDE 21
 */
public class FrontController extends HttpServlet {
    /**to store business logic for login/register functionality*/
    UserBusinessLogic logic = new UserBusinessLogic();
    
    /**to store business logic for vehicle operations*/
    VehicleBusinessLogic vehicleLogic = new VehicleBusinessLogic();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String operation = request.getParameter("operation"); //get the form operation (login or register)
        HttpSession session = request.getSession();
        
        switch(operation){
            case "login":
                attemptLogin(email, password, request, response);
                break;
            case "register":
                //get other user details and build object
                String name = request.getParameter("name");
                UserDTO.UserType type = UserDTO.UserType.valueOf(request.getParameter("usertype"));
                UserDTO user = new UserDTO();
                user.setEmail(email);
                user.setPassword(password);
                user.setName(name);
                user.setType(type);
                
                attemptRegistration(user, request, response);
                break;
            case "logout":
                attemptLogout(request, response);
                break;
            case "manageVehicles":
                request.getRequestDispatcher("/views/VehicleDashboard.jsp").forward(request,response);
                break;
            
            case "viewAllVehicles":
                session.setAttribute("vehicles",vehicleLogic.getAllVehicles());
                request.getRequestDispatcher("/views/AllVehicleList.jsp").forward(request,response);
                break;
            
            case "viewVehicle":
                request.getRequestDispatcher("/views/GetVehicleForm.jsp").forward(request,response);
                break;  
            
            case "viewVehicleProcess":
                viewVehicle(request, response);
                break;
            case "updateVehicle":
                request.getRequestDispatcher("/views/UpdateVehicleForm.jsp").forward(request,response);
                break;

            case "deleteVehicle":
                request.getRequestDispatcher("/views/AllVehicleList.jsp").forward(request,response);
                break;
            
            case "registerVehicle":
                request.getRequestDispatcher("/views/RegisterVehicleForm.jsp").forward(request,response);
                break;
                
            case "registerVehicleProcess":
                //get vehicle details and build object
                String number = request.getParameter("number");
                String fuelType = request.getParameter("fuelType");
                VehicleDTO.VehicleType vehicleType = VehicleDTO.VehicleType.valueOf(request.getParameter("vehicleType"));
                double rate = Double.parseDouble(request.getParameter("consumptionRate"));
                int max = Integer.parseInt(request.getParameter("maxPassengers"));
                String route = request.getParameter("route");
                
                VehicleDTO vehicle = new VehicleDTO();
                vehicle.setNumber(number);
                vehicle.setFuelType(fuelType);
                vehicle.setType(vehicleType);
                vehicle.setConsumptionRate(rate);
                vehicle.setMaxPassengers(max);
                vehicle.setRoute(route);
                
                registerVehicle(vehicle, request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**Validates login using user credential parameters and dispatches to another servlet accordingly
     * @param email the email to validate in login
     * @param pass the password to validate in login
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void attemptLogin(String email, String pass, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //validate login using user business logic
        try{
            //store found user or null
            UserDTO user = logic.validateLogin(email, pass);

            //if valid login
            if(user != null){
                //store user in session as "user"
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                //redirect based on user type
                if(user.getType() == UserDTO.UserType.MANAGER){
                    request.getRequestDispatcher("/views/ManagerMenu.jsp").forward(request,response);
                }
                else{
                    request.getRequestDispatcher("/views/OperatorMenu.jsp").forward(request,response);
                }
            }
            else{
                //store error message if invalid login
                request.setAttribute("error", "Login is invalid, please try again.");
                //reload login
                request.getRequestDispatcher("/Index.jsp").forward(request,response);
            }
        }
        catch(ValidationException e){e.printStackTrace(); e.getMessage();}
    }
    
    /**Validates registration using user credential parameters and dispatches to another servlet accordingly
     * @param user the userdto object to register
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void attemptRegistration(UserDTO user, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //validate registration using user business logic
        try{
           
            //if valid login
            if(logic.registerUser(user)){
                //store user in session as "user"
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                //redirect based on user type
                if(user.getType() == UserDTO.UserType.MANAGER){
                    request.getRequestDispatcher("/views/ManagerMenu.jsp").forward(request,response);
                }
                else{
                    request.getRequestDispatcher("/views/OperatorMenu.jsp").forward(request,response);
                }
            }
            else{//if invalid login
                //reload page
                request.getRequestDispatcher("/views/RegistrationForm.jsp").forward(request,response);
            }
        }
        catch(ValidationException e){e.printStackTrace(); e.getMessage();}
    }
    
    /**Ends login session and redirects to login.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void attemptLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        
        //reload login
        request.getRequestDispatcher("/Index.jsp").forward(request,response);
    }
    
    /**Validates vehicle registration and dispatches to another servlet accordingly
     * @param vehicle the vehicledto object to register
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void registerVehicle(VehicleDTO vehicle, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        try{
            vehicleLogic.registerVehicle(vehicle);
            
            //show updated list
            HttpSession session = request.getSession();
            session.setAttribute("vehicles",vehicleLogic.getAllVehicles());
            request.getRequestDispatcher("/views/AllVehicleList.jsp").forward(request,response);
        }
        catch(ValidationException e){e.printStackTrace();}
    }
    
    /**Retrieves a vehicle
     * @param vehicle the vehicledto object to register
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void viewVehicle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try{
            VehicleDTO foundVehicle = vehicleLogic.getVehicleByNumber(request.getParameter("number"));
            
            HttpSession session = request.getSession();
            session.setAttribute("foundVehicle", foundVehicle);
            request.getRequestDispatcher("/views/GetVehicleForm.jsp").forward(request,response);
        }
        catch(ValidationException e){e.printStackTrace();}
    }
}

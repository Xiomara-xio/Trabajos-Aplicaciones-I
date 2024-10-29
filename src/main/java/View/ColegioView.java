package View;

import Clases.Curso;
import Clases.Estudiante;
import Clases.Matricula;
import Clases.Usuarios;
import Controller.CursoController;
import Controller.EstudianteController;
import Controller.MatriculaController;
import Controller.UsuariosController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    

public class ColegioView extends javax.swing.JFrame {
    String dniInsertadoModificarUsuario;
    String dniInsertadoEliminarUsuario;
    
    
    public ColegioView() {
        initComponents();
    }

    private void cargarDatosCompletos() {
       
    }
    private void actualizarTablaUsuarios() { 
            DefaultTableModel model = (DefaultTableModel) tableUsuario.getModel();
            model.setRowCount(0); 

            UsuariosController userControl = new UsuariosController();

            List<Usuarios> usuario = userControl.obtenerUsuarios();
            for (Usuarios usuarios : usuario) {
                model.addRow(new Object[]{
                    usuarios.getNombre(),
                    usuarios.getApellido(),
                    usuarios.getDni(),
                    usuarios.getUsuario(),
                });
            }
    }
    
    private void limpiarCamposUsuario() {
    txtNombreUsuario.setText("");
    txtapellidoUsuario.setText("");
    txtDniUsuario.setText("");
    txtUsuarioUsuario.setText("");
    txtContraseñaUsuario.setText("");
    }
    private void mostrarTablai(){
            DefaultTableModel model = (DefaultTableModel) tableEstudiante.getModel();
            model.setRowCount(0); // Elimina todas las filas actuales de la tabla

            MatriculaController matriculaController = new MatriculaController();
            EstudianteController estudianteController = new EstudianteController();
            CursoController cursoController = new CursoController();
            
            

            List<Estudiante> estudiantes = estudianteController.obtenerEstudiante();
            List<Matricula> matriculas = matriculaController.obtenerMatricula();
            List<Curso> cursos = cursoController.obtenerCurso();
            
            
           
            Map<Integer, String> cursoMap = new HashMap<>();
            for (Curso curso : cursos) {
                cursoMap.put(curso.getId(), curso.getEstado());
            }   
            Map<Integer, Integer> duracionMap = new HashMap<>();
            for (Curso curso : cursos) {
                cursoMap.put(curso.getId(), curso.getEstado());
                duracionMap.put(curso.getId(), curso.getDuracionSemanas()); // Asumiendo que tienes este método
            }

            
            
            for (Estudiante estudiante : estudiantes) {
                String estado  = cursoMap.getOrDefault(estudiante.getIdCurso(),"");
                Integer duracion = duracionMap.getOrDefault(estudiante.getIdCurso(), 0);
                
                
                model.addRow(new Object[]{
                   estudiante.getId(),
                   estudiante.getNombre(),
                   estudiante.getApellido(),
                   estudiante.getDni(),
                   duracion,
                   estado,
                });
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginColegio = new javax.swing.JFrame();
        panelLogin3 = new javax.swing.JPanel();
        txtUsuarioLogin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtContraseñaLogin = new javax.swing.JPasswordField();
        btnIngresar4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CreanLogin = new javax.swing.JPanel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtapellidoUsuario = new javax.swing.JTextField();
        txtDniUsuario = new javax.swing.JTextField();
        txtUsuarioUsuario = new javax.swing.JTextField();
        txtContraseñaUsuario = new javax.swing.JTextField();
        btnGuardarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnModificarUsuarios = new javax.swing.JButton();
        btnAplicarCamviosUsuario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsuario = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panelAlumnos = new javax.swing.JPanel();
        txtNombreAlumnos = new javax.swing.JTextField();
        txtApellidoAlumno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDuracionAlumnos = new javax.swing.JTextField();
        txtCorreoAlumnos = new javax.swing.JTextField();
        cboModalidad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstudiante = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelCalculos = new javax.swing.JPanel();
        btnCrearLogin = new javax.swing.JButton();
        btnRegistrarAlumno = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();

        LoginColegio.setTitle("MENU PITAKS");
        LoginColegio.setBackground(new java.awt.Color(153, 255, 255));
        LoginColegio.setResizable(false);

        panelLogin3.setBackground(new java.awt.Color(153, 255, 255));

        txtUsuarioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioLoginActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Usuario:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Contraseña:");

        btnIngresar4.setBackground(new java.awt.Color(255, 102, 102));
        btnIngresar4.setText("Ingresar");
        btnIngresar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel12.setText("INICIAR SESION");

        javax.swing.GroupLayout panelLogin3Layout = new javax.swing.GroupLayout(panelLogin3);
        panelLogin3.setLayout(panelLogin3Layout);
        panelLogin3Layout.setHorizontalGroup(
            panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogin3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnIngresar4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
            .addGroup(panelLogin3Layout.createSequentialGroup()
                .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogin3Layout.createSequentialGroup()
                        .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLogin3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogin3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txtContraseñaLogin))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        panelLogin3Layout.setVerticalGroup(
            panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin3Layout.createSequentialGroup()
                .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel13))
                    .addGroup(panelLogin3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(panelLogin3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(panelLogin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnIngresar4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout LoginColegioLayout = new javax.swing.GroupLayout(LoginColegio.getContentPane());
        LoginColegio.getContentPane().setLayout(LoginColegioLayout);
        LoginColegioLayout.setHorizontalGroup(
            LoginColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoginColegioLayout.setVerticalGroup(
            LoginColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginColegioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CreanLogin.setBackground(new java.awt.Color(153, 153, 255));
        CreanLogin.setForeground(new java.awt.Color(102, 102, 255));

        btnGuardarUsuario.setText("Guardar Usuario");
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuarios.setText("Modificar Usuario");
        btnModificarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuariosActionPerformed(evt);
            }
        });

        btnAplicarCamviosUsuario.setText("Aplicar Cambios");
        btnAplicarCamviosUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarCamviosUsuarioActionPerformed(evt);
            }
        });

        tableUsuario.setBackground(new java.awt.Color(204, 255, 204));
        tableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Usuario"
            }
        ));
        jScrollPane2.setViewportView(tableUsuario);

        jLabel14.setText("nombre");

        jLabel15.setText("apellido");

        jLabel16.setText("dni");

        jLabel17.setText("usuario");

        jLabel18.setText("contraseña");

        javax.swing.GroupLayout CreanLoginLayout = new javax.swing.GroupLayout(CreanLogin);
        CreanLogin.setLayout(CreanLoginLayout);
        CreanLoginLayout.setHorizontalGroup(
            CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreanLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAplicarCamviosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CreanLoginLayout.createSequentialGroup()
                        .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreanLoginLayout.createSequentialGroup()
                                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreanLoginLayout.createSequentialGroup()
                                        .addComponent(txtDniUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(CreanLoginLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
                                .addGap(39, 39, 39)
                                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(53, 53, 53)
                                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txtapellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txtUsuarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(txtContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                            .addGroup(CreanLoginLayout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(40, 40, 40)))
                        .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarUsuario)
                            .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarUsuarios))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        CreanLoginLayout.setVerticalGroup(
            CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreanLoginLayout.createSequentialGroup()
                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreanLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(7, 7, 7))
                    .addGroup(CreanLoginLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(20, 20, 20)))
                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarUsuario))
                .addGap(31, 31, 31)
                .addGroup(CreanLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreanLoginLayout.createSequentialGroup()
                        .addComponent(btnEliminarUsuario)
                        .addGap(37, 37, 37)
                        .addComponent(btnModificarUsuarios)
                        .addGap(35, 35, 35)
                        .addComponent(btnAplicarCamviosUsuario))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAlumnos.setBackground(new java.awt.Color(153, 255, 204));
        panelAlumnos.setBorder(javax.swing.BorderFactory.createTitledBorder("EDU GESTION"));
        panelAlumnos.setForeground(new java.awt.Color(255, 153, 51));

        txtNombreAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAlumnosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("DNI");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Apellido");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "NO ACTIVO" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("duracion");

        cboModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRESENCIAL", "VIRTUAL", " " }));
        cboModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboModalidadActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("Correo");

        tableEstudiante.setBackground(new java.awt.Color(204, 204, 255));
        tableEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "DNI", "DuracionSemanas", "Estado", "Correo", "Modalidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEstudiante);

        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setOpaque(false);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnListar)
                        .addComponent(btnAgregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnListar)
                .addGap(18, 18, 18)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnActualizar)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Estado");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Modalidad");

        javax.swing.GroupLayout panelAlumnosLayout = new javax.swing.GroupLayout(panelAlumnos);
        panelAlumnos.setLayout(panelAlumnosLayout);
        panelAlumnosLayout.setHorizontalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(panelAlumnosLayout.createSequentialGroup()
                    .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAlumnosLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelAlumnosLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlumnosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelAlumnosLayout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDuracionAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorreoAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelAlumnosLayout.createSequentialGroup()
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelAlumnosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelAlumnosLayout.setVerticalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAlumnosLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombreAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelAlumnosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDuracionAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAlumnosLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(15, 15, 15)
                                .addComponent(txtCorreoAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlumnosLayout.createSequentialGroup()
                                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtApellidoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)))
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnCrearLogin.setText("Crear login");
        btnCrearLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearLoginActionPerformed(evt);
            }
        });

        btnRegistrarAlumno.setText("Registrar Alumno");
        btnRegistrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCalculosLayout = new javax.swing.GroupLayout(panelCalculos);
        panelCalculos.setLayout(panelCalculosLayout);
        panelCalculosLayout.setHorizontalGroup(
            panelCalculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalculosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCalculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarAlumno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCrearLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelCalculosLayout.setVerticalGroup(
            panelCalculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalculosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnCrearLogin)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarAlumno)
                .addContainerGap(515, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCalculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(panelCalculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombreAlumnos.getText();
        String apellido = txtApellidoAlumno.getText();
        String dni = txtDniAlumno.getText();

        String duracion = txtDuracionAlumnos.getText();
        String estado = cboEstado.getSelectedItem().toString();

        String modalidad = cboModalidad.getSelectedItem().toString();
        String correo = txtCorreoAlumnos.getText().trim();

if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || duracion.isEmpty() || correo.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Ingrese todos los campos");
    return;
}

MatriculaController matriculaController = new MatriculaController();
EstudianteController estudianteController = new EstudianteController();
CursoController cursoController = new CursoController();

int id_matricula = matriculaController.agregarMatriculaObtenerIDMatricula(modalidad, correo);
int id_curso = cursoController.agregarCursoObtenerIDCurso(duracion, estado);
// Verifica que ambos ID sean válidos
if (id_matricula > 0 && id_curso > 0) {
    boolean verificar = estudianteController.agregarEstudiante(id_matricula, id_curso, nombre, apellido, dni);
    
    if (verificar) {
        JOptionPane.showMessageDialog(this, "Se agregó correctamente el estudiante.");
        mostrarTablai();
    } else {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar el estudiante.");
    }
} else {
    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar el curso o la matrícula.");
}
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        cargarDatosCompletos();
    }//GEN-LAST:event_btnListarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        String dniInsertado = JOptionPane.showInputDialog(null, "Por favor, ingresa el DNI del Cliente:");
        
        if (dniInsertado != null && !dniInsertado.trim().isEmpty() ) {
            MatriculaController matriculaController = new MatriculaController();
            EstudianteController estudianteController = new EstudianteController();
            CursoController cursoController = new CursoController();
        
            int id = estudianteController.obtenerIdEstudiantePorDNI(dniInsertado);
      
            boolean ve1 = estudianteController.eliminarEstudiante(dniInsertado);
            boolean ve2 = matriculaController.eliminarMatricula(id);
            boolean ve3 = cursoController.eliminarCurso(id);
            
            if ( ve1 && ve2 && ve3) {
                JOptionPane.showMessageDialog(null, "Se eliminó el registro correctamente.");
                mostrarTablai();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar uno de los registros.");
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
            
        
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cboModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboModalidadActionPerformed
        
    }//GEN-LAST:event_cboModalidadActionPerformed

    private void tableEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEstudianteMouseClicked
        
        
    }//GEN-LAST:event_tableEstudianteMouseClicked

    private void btnCrearLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearLoginActionPerformed
        panelDatos.removeAll();
        CreanLogin.setSize(870,557);
        CreanLogin.setLocation(0, 0);
        panelDatos.add(CreanLogin, BorderLayout.CENTER);
        panelDatos.revalidate();
        panelDatos.repaint();
        CreanLogin.setVisible(true);
        actualizarTablaUsuarios();
    }//GEN-LAST:event_btnCrearLoginActionPerformed

    private void btnIngresar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar4ActionPerformed
        String usuario = txtUsuarioLogin.getText().trim();
        String contra = new String(txtContraseñaLogin.getPassword()).trim();
        
        
        
        
        if (usuario.isEmpty() || contra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellena los campos");
            return;
        }
        
        UsuariosController userControl = new UsuariosController();
        boolean verificar = userControl.verificarCredenciales(usuario, contra);
            
        if (verificar) {
            JOptionPane.showMessageDialog(this, "Credencailes correctas");
            this.setVisible(true);
            LoginColegio.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Credencailes Incorrectas");
        }
        
        
    }//GEN-LAST:event_btnIngresar4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setVisible(false);
        LoginColegio.setVisible(true);
        LoginColegio.setLocationRelativeTo(this); //Centrar la ventana en la pantalla
        LoginColegio.setResizable(false); //La ventana no se modifique por el usuario
        LoginColegio.setSize(new Dimension(470,327));
        LoginColegio.getContentPane().setBackground(new Color(153,255,255));
    }//GEN-LAST:event_formWindowOpened

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        
        String nombre = txtNombreUsuario.getText();
        String apellido = txtapellidoUsuario.getText();
        String dni = txtDniUsuario.getText();
        String usuario = txtUsuarioUsuario.getText();
        String contra = txtContraseñaUsuario.getText();
        
        
        if (nombre.isEmpty() || apellido.isEmpty() ||  dni.isEmpty() ||  usuario.isEmpty() ||  contra.isEmpty()  ) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los cmapos para el registro del usuario");
        }
        String regexSoloLetras = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";

    // Validar que el nombre solo contenga letras
    if (!nombre.matches(regexSoloLetras)) {
        JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras");
        return;
    }

    // Validar que el apellido solo contenga letras
    if (!apellido.matches(regexSoloLetras)) {
        JOptionPane.showMessageDialog(this, "El apellido solo debe contener letras");
        return;
    }

    // Validar que los demás campos no estén vacíos
    if (dni.isEmpty() || usuario.isEmpty() || contra.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese todos los campos para el registro del usuario");
        return;
    }
        
        UsuariosController userControl = new UsuariosController();
        int verificar = userControl.agregarUsuario(nombre, apellido, dni, usuario, contra);
        
        if (verificar > 0) {
            JOptionPane.showMessageDialog(this, "El usuario se ha creado Corecctamente");
            this.setVisible(true);
            LoginColegio.setVisible(false);
            actualizarTablaUsuarios();
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo crear el usuario");
        }
        
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    private void btnRegistrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAlumnoActionPerformed
        panelDatos.removeAll();
        panelAlumnos.setSize(870,557);
        panelAlumnos.setLocation(0, 0);
        panelDatos.add(panelAlumnos, BorderLayout.CENTER);
        panelDatos.revalidate();
        panelDatos.repaint();
        panelAlumnos.setVisible(true);
        
        mostrarTablai();
    }//GEN-LAST:event_btnRegistrarAlumnoActionPerformed

    private void btnModificarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuariosActionPerformed
        
        dniInsertadoModificarUsuario = JOptionPane.showInputDialog(null, "Por favor, ingresa el DNI del Usuario:");    
        
        if (dniInsertadoModificarUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha ingresado el DNI");
        }
        
        UsuariosController userControl = new UsuariosController();
        Usuarios usuario =  userControl.obtenerLosCamposUsuariosModificar(dniInsertadoModificarUsuario);
        if (usuario != null) {
            txtNombreUsuario.setText(usuario.getNombre());
            txtapellidoUsuario.setText(usuario.getApellido());
            txtUsuarioUsuario.setText(usuario.getUsuario());
            txtContraseñaUsuario.setText(usuario.getContraseña());
        }else{
            JOptionPane.showMessageDialog(this, "No se encontrar los datos de este DNI");
        }
    }//GEN-LAST:event_btnModificarUsuariosActionPerformed

    private void btnAplicarCamviosUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarCamviosUsuarioActionPerformed
        
        String nombre = txtNombreUsuario.getText();
        String apellido = txtapellidoUsuario.getText();
        String usuario = txtUsuarioUsuario.getText();
        String contra = txtContraseñaUsuario.getText();
        
        
        
        if (nombre.isEmpty() || apellido.isEmpty()||  usuario.isEmpty() ||  contra.isEmpty()  ) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los cmapos para el registro del usuario");
        }
        
        UsuariosController userControl = new UsuariosController();
        boolean verificar = userControl.actualizarUsuario(nombre, apellido, usuario, contra,dniInsertadoModificarUsuario);
        
        if (verificar ) {
            JOptionPane.showMessageDialog(this, "Se aplico los cambios en el usuario Corecctamente");  
            actualizarTablaUsuarios();
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo modificar el usuario");
        }
        
        
    }//GEN-LAST:event_btnAplicarCamviosUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        
        dniInsertadoEliminarUsuario = JOptionPane.showInputDialog(null, "Ingrese el DNI para eliminar el registro");    
        
        if (dniInsertadoEliminarUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha ingresado el DNI");
        }
        
        UsuariosController userControl = new UsuariosController();
        boolean verificar = userControl.eliminarUsuarioPorDNI(dniInsertadoEliminarUsuario);
        
        if (verificar) {
            JOptionPane.showMessageDialog(this, "Se ha eliminado el usuario correctamente");
        }else{
            JOptionPane.showMessageDialog(this, "No se ha eliminado el usuario");
        }
        
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void txtUsuarioLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioLoginActionPerformed

    private void txtNombreAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlumnosActionPerformed

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
            java.util.logging.Logger.getLogger(ColegioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColegioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColegioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColegioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColegioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JPanel CreanLogin;
    private javax.swing.JFrame LoginColegio;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAplicarCamviosUsuario;
    private javax.swing.JButton btnCrearLogin;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnIngresar4;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificarUsuarios;
    private javax.swing.JButton btnRegistrarAlumno;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboModalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JPanel panelCalculos;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelLogin3;
    private javax.swing.JTable tableEstudiante;
    private javax.swing.JTable tableUsuario;
    private javax.swing.JTextField txtApellidoAlumno;
    private javax.swing.JPasswordField txtContraseñaLogin;
    private javax.swing.JTextField txtContraseñaUsuario;
    private javax.swing.JTextField txtCorreoAlumnos;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtDniUsuario;
    private javax.swing.JTextField txtDuracionAlumnos;
    private javax.swing.JTextField txtNombreAlumnos;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtUsuarioLogin;
    private javax.swing.JTextField txtUsuarioUsuario;
    private javax.swing.JTextField txtapellidoUsuario;
    // End of variables declaration//GEN-END:variables
}

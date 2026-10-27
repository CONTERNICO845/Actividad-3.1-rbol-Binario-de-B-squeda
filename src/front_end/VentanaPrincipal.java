package front_end;

import back_end.ArbolBusqueda;
import back_end.Empleado;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private ArbolBusqueda arbol;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtCargo;
    private JTextField txtArea;
    private JTextField txtSueldo;

    private JButton btnCrearArbol;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnEliminar;
    private JButton btnInOrden;
    private JButton btnPreOrden;
    private JButton btnPostOrden;
    private JButton btnAmplitud;
    private JButton btnProfundidad;
    private JButton btnBalancear;
    private JButton btnDestruir;
    private JButton btnVerArbol;

    private JTextArea txtAreaResultados;
    private JScrollPane scrollResultados;
    private VistaArbolPanel vistaArbolPanel;

    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Árbol Binario de Búsqueda - Gestor de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelDatos = new JPanel(new GridLayout(6, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del Empleado"));

        panelDatos.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelDatos.add(txtId);

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        panelDatos.add(txtCargo);

        panelDatos.add(new JLabel("Área:"));
        txtArea = new JTextField();
        panelDatos.add(txtArea);

        panelDatos.add(new JLabel("Sueldo:"));
        txtSueldo = new JTextField();
        panelDatos.add(txtSueldo);

        JPanel panelBotonesIzq = new JPanel(new GridLayout(4, 1, 5, 5));
        panelBotonesIzq.setBorder(BorderFactory.createTitledBorder("Árbol"));

        btnCrearArbol = new JButton("Crear árbol");
        btnAgregar = new JButton("Agregar empleado");
        btnBuscar = new JButton("Buscar empleado");
        btnEliminar = new JButton("Eliminar empleado");

        btnCrearArbol.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnEliminar.addActionListener(this);

        panelBotonesIzq.add(btnCrearArbol);
        panelBotonesIzq.add(btnAgregar);
        panelBotonesIzq.add(btnBuscar);
        panelBotonesIzq.add(btnEliminar);

        JPanel panelBotonesDer = new JPanel(new GridLayout(8, 1, 5, 5));
        panelBotonesDer.setBorder(BorderFactory.createTitledBorder("Operaciones"));

        btnInOrden = new JButton("Mostrar InOrden");
        btnPreOrden = new JButton("Mostrar PreOrden");
        btnPostOrden = new JButton("Mostrar PostOrden");
        btnAmplitud = new JButton("Calcular amplitud");
        btnProfundidad = new JButton("Calcular profundidad");
        btnBalancear = new JButton("Balancear árbol");
        btnDestruir = new JButton("Destruir árbol");
        btnVerArbol = new JButton("Ver estructura");

        btnInOrden.addActionListener(this);
        btnPreOrden.addActionListener(this);
        btnPostOrden.addActionListener(this);
        btnAmplitud.addActionListener(this);
        btnProfundidad.addActionListener(this);
        btnBalancear.addActionListener(this);
        btnDestruir.addActionListener(this);
        btnVerArbol.addActionListener(this);

        panelBotonesDer.add(btnInOrden);
        panelBotonesDer.add(btnPreOrden);
        panelBotonesDer.add(btnPostOrden);
        panelBotonesDer.add(btnAmplitud);
        panelBotonesDer.add(btnProfundidad);
        panelBotonesDer.add(btnBalancear);
        panelBotonesDer.add(btnDestruir);
        panelBotonesDer.add(btnVerArbol);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelDatos, BorderLayout.CENTER);
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.add(panelBotonesIzq);
        panelBotones.add(panelBotonesDer);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        txtAreaResultados = new JTextArea();
        txtAreaResultados.setEditable(false);
        scrollResultados = new JScrollPane(txtAreaResultados);
        scrollResultados.setBorder(BorderFactory.createTitledBorder("Resultados / Mensajes"));

        vistaArbolPanel = new VistaArbolPanel();

        JPanel panelInferior = new JPanel(new GridLayout(2, 1, 5, 5));
        panelInferior.add(scrollResultados);
        panelInferior.add(vistaArbolPanel);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearArbol) {
            crearArbol();
        } else if (e.getSource() == btnAgregar) {
            agregarEmpleado();
        } else if (e.getSource() == btnBuscar) {
            buscarEmpleado();
        } else if (e.getSource() == btnEliminar) {
            eliminarEmpleado();
        } else if (e.getSource() == btnInOrden) {
            mostrarInOrden();
        } else if (e.getSource() == btnPreOrden) {
            mostrarPreOrden();
        } else if (e.getSource() == btnPostOrden) {
            mostrarPostOrden();
        } else if (e.getSource() == btnAmplitud) {
            calcularAmplitud();
        } else if (e.getSource() == btnProfundidad) {
            calcularProfundidad();
        } else if (e.getSource() == btnBalancear) {
            balancearArbol();
        } else if (e.getSource() == btnDestruir) {
            destruirArbol();
        } else if (e.getSource() == btnVerArbol) {
            verArbol();
        }
    }

    private void crearArbol() {
        arbol = new ArbolBusqueda();
        txtAreaResultados.setText("Árbol listo para usarse.");
    }

    private void agregarEmpleado() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }

        String idStr = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String cargo = txtCargo.getText().trim();
        String area = txtArea.getText().trim();
        String sueldoStr = txtSueldo.getText().trim();

        if (idStr.isEmpty() || nombre.isEmpty() || cargo.isEmpty() || area.isEmpty() || sueldoStr.isEmpty()) {
            txtAreaResultados.setText("Todos los campos son obligatorios.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            txtAreaResultados.setText("ID inválido. Debe ser un número entero.");
            return;
        }

        if (arbol.buscar(id) != null) {
            txtAreaResultados.setText("Ya existe un empleado con ese ID.");
            return;
        }

        double sueldo;
        try {
            sueldo = Double.parseDouble(sueldoStr);
        } catch (NumberFormatException ex) {
            txtAreaResultados.setText("Sueldo inválido. Debe ser un número.");
            return;
        }

        if (sueldo < 0) {
            txtAreaResultados.setText("El sueldo no puede ser negativo.");
            return;
        }

        Empleado empleado = new Empleado(id, nombre, cargo, area, sueldo);
        arbol.insertar(empleado);
        txtAreaResultados.setText("Empleado agregado correctamente:\n" + empleado.toString());
    }

    private void buscarEmpleado() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }

        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            txtAreaResultados.setText("Ingrese el ID para buscar.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            txtAreaResultados.setText("ID inválido. Debe ser un número entero.");
            return;
        }

        Empleado encontrado = arbol.buscar(id);
        if (encontrado == null) {
            txtAreaResultados.setText("No se encontró el empleado con ese ID.");
            return;
        }

        txtAreaResultados.setText("Empleado encontrado:\n" + encontrado.toString());
    }

    private void eliminarEmpleado() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }

        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }

        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            txtAreaResultados.setText("Ingrese el ID para eliminar.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            txtAreaResultados.setText("ID inválido. Debe ser un número entero.");
            return;
        }

        Empleado encontrado = arbol.buscar(id);
        if (encontrado == null) {
            txtAreaResultados.setText("No se encontró el empleado con ese ID.");
            return;
        }

        arbol.eliminar(id);
        txtAreaResultados.setText("Empleado eliminado correctamente.\n" + encontrado.toString());
    }

    private void mostrarInOrden() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }
        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }
        txtAreaResultados.setText("Recorrido InOrden (ascendente por ID):\n" + arbol.mostrarInOrden());
    }

    private void mostrarPreOrden() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }
        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }
        txtAreaResultados.setText("Recorrido PreOrden:\n" + arbol.mostrarPreOrden());
    }

    private void mostrarPostOrden() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }
        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }
        txtAreaResultados.setText("Recorrido PostOrden:\n" + arbol.mostrarPostOrden());
    }

    private void calcularAmplitud() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }
        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }
        txtAreaResultados.setText("Amplitud máxima (máximo de nodos por nivel): " + arbol.amplitud());
    }

    private void calcularProfundidad() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }
        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }
        txtAreaResultados.setText("Profundidad máxima del árbol (en niveles): " + arbol.profundidad());
    }

    private void balancearArbol() {
        if (arbol == null) {
            txtAreaResultados.setText("No se ha creado el árbol. Presione Crear árbol primero.");
            return;
        }
        if (arbol.estaVacio()) {
            txtAreaResultados.setText("El árbol está vacío.");
            return;
        }
        arbol.balancear();
        txtAreaResultados.setText("Árbol balanceado correctamente. Se conservaron todos los empleados.\nProfundidad máxima (en niveles): " + arbol.profundidad());
    }

    private void destruirArbol() {
        if (arbol == null) {
            txtAreaResultados.setText("El árbol ya no existe o ya fue destruido.");
            if (vistaArbolPanel != null) {
                vistaArbolPanel.limpiar();
            }
            return;
        }
        arbol.destruirArbol();
        arbol = null;
        txtAreaResultados.setText("Árbol destruido. Se ha eliminado toda la información.");
        if (vistaArbolPanel != null) {
            vistaArbolPanel.limpiar();
        }
    }

    private void verArbol() {
        if (vistaArbolPanel != null) {
            vistaArbolPanel.mostrarArbol(arbol);
        }
    }
}

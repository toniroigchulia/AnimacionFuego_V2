import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class PaletteConfiguration extends JPanel {

    private JLabel temp;
    private JLabel RGBA;
    private JTable table;

    public PaletteConfiguration() {
        this.setLayout(new GridBagLayout());
        addContentToPane(this);
    }

    private void addContentToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();
        Object[][] data = {
                { new Color(0, 0, 0, 0), 0, "X" },
                { new Color(0, 0, 0, 100), 55, "X" },
                { new Color(155, 0, 0, 110), 60, "X" },
                { new Color(200, 100, 0, 180), 72, "X" },
                { new Color(235, 235, 40, 250), 112, "X" },
                { new Color(255, 255, 200, 255), 130, "X" },
                { new Color(255, 255, 255, 255), 155, "X" },
                { new Color(255, 255, 255, 255), 255, "X" }
        };

        String[] columnNames = { "Temperature", "TargetColor", "Remove" };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Color.class : Integer.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {

                if (row == table.getRowCount() - 1 || row == 0) {

                    return false;
                } else {

                    return true;
                }
            }
        };

        table = new JTable(model);
        // Añadimos a la primera columna la capacidad para elejir color y guardarlo en esta
        this.table.getColumnModel().getColumn(0).setCellEditor(new ColorChooserEditor());
        this.table.getColumnModel().getColumn(0).setCellRenderer(new ColorChooserRenderer());

        // Añadimos a la tercera columna el boton de eliminar columa
        this.table.getColumn("Remove").setCellRenderer(new ColorChooserButtonRenderer());
        this.table.getColumn("Remove").setCellEditor(new ColorChooserButtonEditor(new JCheckBox(), table));
        table.setRowHeight(20);

        JButton addButton = new JButton("Add Row");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = { new Color(255, 255, 255, 255), 255, "X" };
                model.addRow(row);
            }
        });

        // Añadimos los column headers
        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(1, 1, 1, 5);
        temp = new JLabel("RGBA");
        panel.add(temp, c);

        c.gridx = 1;
        RGBA = new JLabel("Temp");
        panel.add(RGBA, c);

        // Añadimos la table
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(table, c);

        // Añadimos el boton para los rows
        c.gridy = 0;
        panel.add(addButton, c);
    }

    // METODOS

    public ArrayList<ColorTarget> getColorTargets() {
        ArrayList<ColorTarget> colorTargets = new ArrayList<ColorTarget>();

        for (int i = 0; i < table.getRowCount(); i++) {
            ColorTarget colorTarget = new ColorTarget((Color) table.getValueAt(i, 0), (int) table.getValueAt(i, 1));
            colorTargets.add(colorTarget);
        }

        return colorTargets;
    }

    // Classes para la modificacion de la tabla
    public class ColorChooserRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof Color) {
                component.setBackground((Color) value);
                component.setForeground(new Color(255, 255, 255, 0));
            }
            return component;
        }
    }

    public class ColorChooserEditor extends AbstractCellEditor implements TableCellEditor {
        private ColorChooserPanel colorChooserPanel;

        ColorChooserEditor() {

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            this.colorChooserPanel = new ColorChooserPanel();
            return colorChooserPanel;
        }

        @Override
        public Object getCellEditorValue() {
            return colorChooserPanel.getColor();
        }

    }

    public class ColorChooserPanel extends JPanel {
        private Color selectedColor;

        public ColorChooserPanel() {
            selectedColor = JColorChooser.showDialog(ColorChooserPanel.this, "Color Chooser", selectedColor);
        }

        Color getColor() {
            return selectedColor;
        }

        void setColor(Color color) {
            selectedColor = color;
        }
    }

    // Metodo para añadir la funcionalidad al boton de la tabla
    public class ColorChooserButtonEditor extends DefaultCellEditor {
        protected JButton button;

        public ColorChooserButtonEditor(JCheckBox checkBox, JTable table) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setText("X");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int modelRow = table.convertRowIndexToModel(table.getEditingRow());
                    ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            button.setText("X");
            return button;
        }
    }

    // Metodo Para renderizar el boton en la casilla
    public class ColorChooserButtonRenderer extends JButton implements TableCellRenderer {
        public ColorChooserButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText("X");
            return this;
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JocDeCarti extends JFrame {

    private JComboBox<String> selectieJoc;
    private JButton startButton;
    private List<JLabel> labeluriJucatori;

    public JocDeCarti() {
        // Setari initiale pentru fereastra
        setTitle("Joc de Carti");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initializare componente
        selectieJoc = new JComboBox<>(new String[]{"Poker", "Tabinet", "Macao"});
        startButton = new JButton("Start Joc");
        labeluriJucatori = new ArrayList<>();

        // Adaugare ascultator pentru buton
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jocSelectat = (String) selectieJoc.getSelectedItem();
                simuleazaJoc(jocSelectat, 4);
            }
        });

        // Adaugare componente la content pane
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(creazaPanelSelectieJoc(), BorderLayout.NORTH);
        contentPane.add(creazaPanelJucatori(), BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }

    private JPanel creazaPanelSelectieJoc() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Selectați jocul:"));
        panel.add(selectieJoc);
        return panel;
    }

    private JPanel creazaPanelJucatori() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        for (int i = 0; i < 4; i++) {
            JPanel panelJucator = new JPanel(new FlowLayout());
            JLabel labelJucator = new JLabel("Jucator " + (i + 1) + ": ");
            labeluriJucatori.add(labelJucator);
            panelJucator.add(labelJucator);
            panel.add(panelJucator);
        }
        return panel;
    }

    private void simuleazaJoc(String joc, int numarJucatori) {
        if ("Poker".equals(joc)) {
            simuleazaJocPoker(numarJucatori);
        } else if ("Tabinet".equals(joc)) {
            simuleazaJocTabinet(numarJucatori);
        } else if ("Macao".equals(joc)) {
            simuleazaJocMacao(numarJucatori);
        }
    }

    private void simuleazaJocPoker(int numarJucatori) {
        List<String> pachet = genereazaPachetDeCarti();
        amestecaCartile(pachet);

        // Distribuie cărțile jucătorilor
        List<List<String>> mainiJucatori = new ArrayList<>();
        for (int i = 0; i < numarJucatori; i++) {
            List<String> mana = new ArrayList<>();
            for (int j = i; j < pachet.size(); j += numarJucatori) {
                mana.add(pachet.get(j));
            }
            mainiJucatori.add(mana);
        }

        // Afiseaza mainile jucatorilor
        for (int i = 0; i < numarJucatori; i++) {
            StringBuilder textMana = new StringBuilder("<html>Mană: ");
            for (String carte : mainiJucatori.get(i)) {
                textMana.append(carte).append("<br>");
            }
            textMana.append("</html>");
            labeluriJucatori.get(i).setText(textMana.toString());
        }

        // Determina castigatorii
        determinaCastigatorii("Poker", numarJucatori);
    }

    private void simuleazaJocTabinet(int numarJucatori) {
        // Implementați logica pentru jocul Tabinet
        // ...

        // Simulare: Determinați un câștigător aleatoriu între 1 și numarJucatori
        Random random = new Random();
        int castigator = random.nextInt(numarJucatori) + 1;
        afiseazaCastigator("Tabinet", castigator);
    }

    private void determinaCastigatorii(String joc, int numarJucatori) {
        if ("Poker".equals(joc)) {
            determinaCastigatorPoker(numarJucatori);
        } else if ("Tabinet".equals(joc)) {
            determinaCastigatorTabinet(numarJucatori);
        } else if ("Macao".equals(joc)) {
            determinaCastigatorMacao(numarJucatori);
        }
    }



    private void determinaCastigatorPoker(int numarJucatori) {
        // Adauga logica pentru determinarea castigatorului la Poker
        // ...

        // Simulare: Determinați un câștigător aleatoriu
        Random random = new Random();
        int castigator = random.nextInt(numarJucatori) + 1;
        afiseazaCastigator("Poker", castigator);
    }

    private void determinaCastigatorTabinet(int numarJucatori) {
        // Adauga logica pentru determinarea castigatorului la Tabinet
        // ...

        // Simulare: Determinați un câștigător aleatoriu între 1 și numarJucatori
        Random random = new Random();
        int castigator = random.nextInt(numarJucatori) + 1;
        afiseazaCastigator("Tabinet", castigator);
    }

    private void determinaCastigatorMacao(int numarJucatori) {
        // Adauga logica pentru determinarea castigatorului la Macao
        // ...

        // Simulare: Determinați un câștigător aleatoriu
        Random random = new Random();
        int castigator = random.nextInt(numarJucatori) + 1;
        afiseazaCastigator("Macao", castigator);
    }

    private void simuleazaJocMacao(int numarJucatori) {
        List<String> pachet = genereazaPachetDeCarti();
        amestecaCartile(pachet);

        // Distribuie cărțile jucătorilor
        List<List<String>> mainiJucatori = new ArrayList<>();
        for (int i = 0; i < numarJucatori; i++) {
            List<String> mana = new ArrayList<>();
            for (int j = i; j < pachet.size(); j += numarJucatori) {
                mana.add(pachet.get(j));
            }
            mainiJucatori.add(mana);
        }

        // Afiseaza mainile jucatorilor
        for (int i = 0; i < numarJucatori; i++) {
            StringBuilder textMana = new StringBuilder("<html>Mană: ");
            for (String carte : mainiJucatori.get(i)) {
                textMana.append(carte).append("<br>");
            }
            textMana.append("</html>");
            labeluriJucatori.get(i).setText(textMana.toString());
        }

        // Determina castigatorii
        determinaCastigatorii("Macao", numarJucatori);
    }

    private void afiseazaCastigator(String joc, int castigator) {
        JOptionPane.showMessageDialog(this, "Castigator " + joc + ": Jucator " + castigator);
    }

    private List<String> genereazaPachetDeCarti() {
        List<String> pachet = new ArrayList<>();
        String[] culori = {"Inima", "Romb", "Trefla", "Frunza"};
        String[] valori = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String culoare : culori) {
            for (String valoare : valori) {
                pachet.add(valoare + " " + culoare);
            }
        }

        // Adauga Jokerii
        pachet.add("Joker");
        pachet.add("Joker");

        return pachet;
    }
    private void amestecaCartile(List<String> pachet) {
        Collections.shuffle(pachet);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JocDeCarti().setVisible(true);
            }
        });
    }
}
import ALGORITHMS.Searching;
import ALGORITHMS.Sorting;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class AlgorithmGUI extends JFrame {
    private JComboBox<String> modeBox;
    private JComboBox<String> algoBox;
    private JTextField inputField;
    private JTextField searchField;
    private JButton runButton;
    private JTextArea resultArea;

    private static final String[] MODES = {"Sorting", "Searching"};
    private static final String[] SORT_ALGOS = {
        "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Counting Sort", "Quick Sort", "Heap Sort", "Shell Sort", "Bucket Sort", "Radix Sort"
    };
    private static final String[] SEARCH_ALGOS = {
        "Linear Search", "Binary Search"
    };

    public AlgorithmGUI() {
        setTitle("Algorithm Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        topPanel.add(new JLabel("Mode:"), gbc);
        gbc.gridx = 1;
        modeBox = new JComboBox<>(MODES);
        modeBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        topPanel.add(modeBox, gbc);
        gbc.gridx = 2;
        topPanel.add(new JLabel("Algorithm:"), gbc);
        gbc.gridx = 3;
        algoBox = new JComboBox<>(SORT_ALGOS);
        algoBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        topPanel.add(algoBox, gbc);
        add(topPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Input numbers (comma separated):"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        inputPanel.add(inputField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(new JLabel("Search value (for searching):"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        searchField = new JTextField();
        searchField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        inputPanel.add(searchField, gbc);
        add(inputPanel, BorderLayout.CENTER);

        runButton = new JButton("Run");
        runButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        buttonPanel.add(runButton);
        add(buttonPanel, BorderLayout.SOUTH);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, inputPanel, scrollPane);
        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);

        searchField.setEnabled(false);

        modeBox.addActionListener(e -> {
            if (modeBox.getSelectedIndex() == 0) {
                algoBox.setModel(new DefaultComboBoxModel<>(SORT_ALGOS));
                searchField.setEnabled(false);
            } else {
                algoBox.setModel(new DefaultComboBoxModel<>(SEARCH_ALGOS));
                searchField.setEnabled(true);
            }
        });

        runButton.addActionListener(e -> runAlgorithm());
    }

    private void runAlgorithm() {
        String mode = (String) modeBox.getSelectedItem();
        String algo = (String) algoBox.getSelectedItem();
        String inputText = inputField.getText().trim();
        String[] tokens = inputText.split(",");
        resultArea.setText("");
        try {
            if (mode.equals("Sorting")) {
                if (algo.equals("Counting Sort") || algo.equals("Radix Sort")) {
                    int[] arr = Arrays.stream(tokens).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
                    int[] sorted = null;
                    String key = "";
                    if (algo.equals("Counting Sort")) {
                        sorted = Sorting.countingSort(arr);
                        key = "counting";
                    } else {
                        sorted = Sorting.radixSort(arr);
                        key = "radix";
                    }
                    resultArea.append("Sorted: " + Arrays.toString(sorted) + "\n");
                    resultArea.append(Sorting.getTimeComplexity(key));
                } else {
                    double[] arr = Arrays.stream(tokens).filter(s -> !s.isEmpty()).mapToDouble(Double::parseDouble).toArray();
                    double[] sorted = null;
                    String key = "";
                    switch (algo) {
                        case "Bubble Sort":
                            sorted = Sorting.bubbleSort(arr);
                            key = "bubble";
                            break;
                        case "Selection Sort":
                            sorted = Sorting.selectionSort(arr);
                            key = "selection";
                            break;
                        case "Insertion Sort":
                            sorted = Sorting.insertionSort(arr);
                            key = "insertion";
                            break;
                        case "Merge Sort":
                            sorted = Sorting.mergeSort(arr);
                            key = "merge";
                            break;
                        case "Quick Sort":
                            sorted = Sorting.quickSort(arr);
                            key = "quick";
                            break;
                        case "Heap Sort":
                            sorted = Sorting.heapSort(arr);
                            key = "heap";
                            break;
                        case "Shell Sort":
                            sorted = Sorting.shellSort(arr);
                            key = "shell";
                            break;
                        case "Bucket Sort":
                            sorted = Sorting.bucketSort(arr);
                            key = "bucket";
                            break;
                    }
                    resultArea.append("Sorted: " + Arrays.toString(sorted) + "\n");
                    resultArea.append(Sorting.getTimeComplexity(key));
                }
            } else {
                double[] arr = Arrays.stream(tokens).filter(s -> !s.isEmpty()).mapToDouble(Double::parseDouble).toArray();
                double target = Double.parseDouble(searchField.getText().trim());
                int index = -1;
                String key = "";
                if (algo.equals("Linear Search")) {
                    index = Searching.linearSearch(arr, target);
                    key = "linear";
                } else {
                    index = Searching.binarySearch(arr, target);
                    key = "binary";
                }
                if (index != -1) {
                    resultArea.append("Found at index: " + index + "\n");
                } else {
                    resultArea.append("Not found\n");
                }
                resultArea.append(Searching.getTimeComplexity(key));
            }
        } catch (Exception ex) {
            resultArea.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlgorithmGUI().setVisible(true));
    }
} 
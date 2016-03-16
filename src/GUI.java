/**
 * Created by Garth on 04/02/2016.
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class GUI extends JFrame implements ActionListener {

    JLabel lblBubbleOrg, lblBubbleEnh, lblSelection, lblInsertion, txtArrayNo;
    JPanel panel1, panel2, panel3, panel4, panel5;
    ButtonGroup buttonGroup = new ButtonGroup();
    private TextArea txtBubbleOrg1, txtBubbleEnh1, txtSelection1, txtInsertion1;
    private TextArea txtBubbleOrg2, txtBubbleEnh2, txtSelection2, txtInsertion2;
    private TextArea txtBubbleOrg3, txtBubbleEnh3, txtSelection3, txtInsertion3;
    private JButton btnBubbleOrg, btnBubbleEnh, btnSelection, btnInsertion;
    private JRadioButton rb1000, rb10000, rb100000;
    private static int selectedArraySize;
    private static StopWatch stopWatch = new StopWatch();
    private static long bubbleOrgSwaps, bubbleEnhSwaps, selectionSwaps, insertionSwaps = 0;
    private static int bubbleOrgComp, bubbleEnhComp, selectionComp, insertionComp = 0;
    private static int[] sortedList1, randomList1, inverseList1, sortedList2, randomList2, inverseList2,
                    sortedList3, randomList3, inverseList3, sortedList4, randomList4, inverseList4 = new int[]{};

    public GUI() {

        setTitle("Quadratic Algorithm Analysis");
        setLayout(new GridLayout(5, 0, 5, 5));

        // Panel 1 - dropDown + label ***************
        panel1 = new JPanel();
        // Constructing components and adding to panel
        panel1.add(txtArrayNo = new JLabel("Please select the number of elements for your array:"), BorderLayout.NORTH);
        rb1000 = new JRadioButton("1000");
        rb1000.addActionListener(this);
        rb10000 = new JRadioButton("10000");
        rb10000.addActionListener(this);
        rb100000 = new JRadioButton("100000");
        rb100000.addActionListener(this);
        panel1.add(rb1000);
        panel1.add(rb10000);
        panel1.add(rb100000);
        buttonGroup.add(rb1000);
        buttonGroup.add(rb10000);
        buttonGroup.add(rb100000);
        add(panel1);


        // Panel 2 - Sorted Array Analysis ***************
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 4, 5, 5));
        // Constructing components and adding to panel
        // TextFields
        txtBubbleOrg1 = new TextArea("txtBubbleOrg1");
        txtBubbleEnh1 = new TextArea("txtBubbleEnh1");
        txtSelection1 = new TextArea("txtSelection1");
        txtInsertion1 = new TextArea("txtInsertion1");
        // Labels
        lblBubbleOrg = new JLabel("Bubble (Original) sort:");
        lblBubbleEnh = new JLabel("Bubble (Enhanced) sort:");
        lblSelection = new JLabel("Selection sort:");
        lblInsertion = new JLabel("Insertion sort :");
        // Adding components to panel 2
        panel2.add(lblBubbleOrg);
        panel2.add(lblBubbleEnh);
        panel2.add(lblSelection);
        panel2.add(lblInsertion);
        panel2.add(txtBubbleOrg1);
        panel2.add(txtBubbleEnh1);
        panel2.add(txtSelection1);
        panel2.add(txtInsertion1);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK), "Sorted Array Analysis",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman", Font.BOLD, 16), Color.blue));
        add(panel2, BorderLayout.NORTH);

        // Panel 3 - Sorted Array Analysis ***************
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 4, 5, 5));
        // Constructing components and adding to panel
        // TextFields
        txtBubbleOrg2 = new TextArea("txtBubbleOrg2");
        txtBubbleEnh2 = new TextArea("txtBubbleEnh2");
        txtSelection2 = new TextArea("txtSelection2");
        txtInsertion2 = new TextArea("txtInsertion2");
        lblBubbleOrg = new JLabel("Bubble (Original) sort:");
        lblBubbleEnh = new JLabel("Bubble (Enhanced) sort:");
        lblSelection = new JLabel("Selection sort:");
        lblInsertion = new JLabel("Insertion sort:");
        panel3.add(lblBubbleOrg);
        panel3.add(lblBubbleEnh);
        panel3.add(lblSelection);
        panel3.add(lblInsertion);
        panel3.add(txtBubbleOrg2);
        panel3.add(txtBubbleEnh2);
        panel3.add(txtSelection2);
        panel3.add(txtInsertion2);
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK), "Unsorted Array Analysis",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman", Font.BOLD, 16), Color.blue));
        add(panel3, BorderLayout.CENTER);

        // Panel 4 - Random array analysis
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2, 4, 5, 5));
        // Constructing components and adding to panel
        // TextFields
        txtBubbleOrg3 = new TextArea("txtBubbleOrg3");
        txtBubbleEnh3 = new TextArea("txtBubbleEnh3");
        txtSelection3 = new TextArea("txtSelection3");
        txtInsertion3 = new TextArea("txtInsertion3");
        lblBubbleOrg = new JLabel("Bubble (Original) sort:");
        lblBubbleEnh = new JLabel("Bubble (Enhanced) sort:");
        lblSelection = new JLabel("Selection sort:");
        lblInsertion = new JLabel("Insertion sorts:");
        panel4.add(lblBubbleOrg);
        panel4.add(lblBubbleEnh);
        panel4.add(lblSelection);
        panel4.add(lblInsertion);
        panel4.add(txtBubbleOrg3);
        panel4.add(txtBubbleEnh3);
        panel4.add(txtSelection3);
        panel4.add(txtInsertion3);
        panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK), "Inverse Array Analysis",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman", Font.BOLD, 16), Color.blue));
        add(panel4, BorderLayout.SOUTH);

        // Panel 5 - Buttons ***************
        // Constructing components and adding to panel
        panel5 = new JPanel();
        btnBubbleOrg = new JButton("BubbleOrg");
        btnBubbleOrg.addActionListener(this);
        btnBubbleEnh = new JButton("BubbleEnh");
        btnBubbleEnh.addActionListener(this);
        btnSelection = new JButton("Selection");
        btnSelection.addActionListener(this);
        btnInsertion = new JButton("Insertion");
        btnInsertion.addActionListener(this);
        panel5.add(btnBubbleOrg);
        panel5.add(btnBubbleEnh);
        panel5.add(btnSelection);
        panel5.add(btnInsertion);
        add(panel5);



    }

    // ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "1000" : selectedArraySize = 1000;
                rb1000.setEnabled(false);
                setButtonEnabled(true);
                createArrays();
                break;
            case "10000" : selectedArraySize = 10000;
                rb10000.setEnabled(false);
                setButtonEnabled(true);
                createArrays();
                break;
            case "100000" : selectedArraySize = 100000;
                rb100000.setEnabled(false);
                setButtonEnabled(true);
                createArrays();
                break;
            case "BubbleOrg": // Calls to Original Bubble Sort Algorithm
                getBubbleSortAlgorithmOriginal(sortedList1);
                txtBubbleOrg1.setText(String.valueOf(stopWatch.getElapsedTime()) + "Milliseconds & \n" + bubbleOrgSwaps +
                        " Swaps & " +bubbleOrgComp + " Comps");
                stopWatch.reset();
                getBubbleSortAlgorithmOriginal(randomList1);
                txtBubbleOrg2.setText(String.valueOf(stopWatch.getElapsedTime()) + "Milliseconds & \n" + bubbleOrgSwaps +
                        " Swaps & " +bubbleOrgComp + " Comps");
                stopWatch.reset();
                getBubbleSortAlgorithmOriginal(inverseList1);
                txtBubbleOrg3.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + bubbleOrgSwaps +
                        " Swaps & " +bubbleOrgComp + " Comps");
                stopWatch.reset();
                btnBubbleOrg.setEnabled(false); // Stop user from clicking button again
            break;
            case "BubbleEnh": // Calls to Enhanced Bubble Sort Algorithm
                getBubbleSortAlgorithmEnhanced(sortedList2);
                txtBubbleEnh1.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + bubbleEnhSwaps +
                        " Swaps & " +bubbleEnhComp + " Comps");
                stopWatch.reset();
                getBubbleSortAlgorithmEnhanced(randomList2);
                txtBubbleEnh2.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + bubbleEnhSwaps +
                        " Swaps & " +bubbleEnhComp + " Comps");
                stopWatch.reset();
                getBubbleSortAlgorithmEnhanced(inverseList2);
                txtBubbleEnh3.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + bubbleEnhSwaps +
                        " Swaps & " +bubbleEnhComp + " Comps");
                stopWatch.reset();
                btnBubbleEnh.setEnabled(false);
                break;
            case "Selection": // Calls to Selection Sort Algorithm
                getSelectionSortAlgorithm(sortedList3);
                txtSelection1.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + selectionSwaps +
                        " Swaps & " +selectionComp + " Comps");
                stopWatch.reset();
                getSelectionSortAlgorithm(randomList3);
                txtSelection2.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + selectionSwaps +
                        " Swaps & " +selectionComp + " Comps");
                stopWatch.reset();
                getSelectionSortAlgorithm(inverseList3);
                txtSelection3.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + selectionSwaps +
                        " Swaps & " +selectionComp + " Comps");
                stopWatch.reset();
                btnSelection.setEnabled(false);
                break;
            case "Insertion": // Calls to Insertion Sort Algorithm
                getInsertionSortAlgorithm(sortedList4);
                txtInsertion1.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + insertionSwaps +
                        " Swaps & " +insertionComp + " Comps");
                stopWatch.reset();
                getInsertionSortAlgorithm(randomList4);
                txtInsertion2.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + insertionSwaps +
                        " Swaps & " +insertionComp + " Comps");
                stopWatch.reset();
                getInsertionSortAlgorithm(inverseList4);
                txtInsertion3.setText(String.valueOf(stopWatch.getElapsedTime()) + " Milliseconds & \n" + insertionSwaps +
                        " Swaps & " +insertionComp + " Comps");
                stopWatch.reset();
                btnInsertion.setEnabled(false);
                break;
        }
    }

    // Algorithms

    public static int[] getBubbleSortAlgorithmOriginal(int[] list) {
        bubbleOrgSwaps=0;
        bubbleOrgComp=0;

        stopWatch.start();
        int temp;
        for(int i = 0; i < list.length-1; i++){
            bubbleOrgComp++;
            for(int j = 0; j < list.length-1; j++){
                if(list[j] > list[j+1]){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    bubbleOrgSwaps++;
                }
            }
        }
        stopWatch.stop();
        return list;
    }

    public static int[] getBubbleSortAlgorithmEnhanced(int[] list) {
        bubbleEnhSwaps=0;
        bubbleEnhComp=0;
        stopWatch.start();
        int temp;
        boolean sorted = false;
        for(int i = 0; i < list.length-1 && !sorted; i++){ // "&& !sorted" : End if the array is sorted
            sorted = true;
            for(int j = 0; j < list.length-1-i; j++)	{
                bubbleEnhComp++;
                if(list[j] > list[j+1]){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    sorted = false; // If a swap occurs, the array wasn't sorted
                    bubbleEnhSwaps++;
                }
            }
        }
        stopWatch.stop();
        return list;
    }

    public static int[] getSelectionSortAlgorithm(int[] list) {
        selectionSwaps=0;
        selectionComp=0;
        stopWatch.start();
        for (int i = 0; i < list.length - 1; i++)      // start at the beginning of the whole array
        {
            selectionComp++;
            int minimum = i;    // (1) default value of the 1st element index � use this to test against every other element.
            for (int j = i + 1; j < list.length; j++)      // (2) loop from the beginning of unsorted zone to the end of the array.
            {
                if (list[j] < list[minimum]) {  // compare current element to minimum
                    minimum = j;    // if it's lower, it becomes the new minimum
                    selectionSwaps++;
                }
            }

            // swap the two values

            int temp = list[i];
            list[i] = list[minimum];
            list[minimum] = temp;
        }
        stopWatch.stop();
        return list;

    }

    public static int[] getInsertionSortAlgorithm(int[] list) {
        insertionSwaps=0;
        insertionComp=0;
        stopWatch.start();
        for (int i = 1; i < list.length; i++) {
            insertionComp++;
            int next = list[i];
            // find the insertion location while moving all larger element up
            int j = i;
            while (j > 0 && list[j - 1] > next) {
                list[j] = list[j - 1];
                j--;
                insertionSwaps++;
            }
            // insert the element
            list[j] = next;
        }
        stopWatch.stop();
        return list;
    }

    /**
     * Generates an array list full of random numbers
     * @param noOfElements the size the user wants the array list to be
     * @return the array list full of random numbers
     */
    public static int[] generateRandomList(int noOfElements) {
        Random randomGenerator = new Random();
        int[] listRandNos = new int[noOfElements];

        for (int i = 0; i < listRandNos.length; i++)
            listRandNos[i] = randomGenerator.nextInt(100);

        return listRandNos;
    }

    /**
     * Generates a sorted array list
     * @param noOfElements the size the user wants the array list to be
     * @return the array list full of sorted numbers
     */
    public static int[] generateSortedList(int noOfElements) {
        Random randomGenerator = new Random();
        int[] listRandNos = new int[noOfElements];

        for (int i = 0; i < listRandNos.length; i++)
            listRandNos[i] = randomGenerator.nextInt(100);

        Arrays.sort(listRandNos);
        return listRandNos;
    }

    /**
     * Generates an inverse array list
     * @param noOfElements the size the user wants the array list to be
     * @return the inverse array list
     */
    public static int[] generateInverseList(int noOfElements) {
        int[] list = new int[noOfElements];

        for (int i = 1; i < list.length; i++) {
            list[i] = list.length-i;
        }

        return list;
    }

    public static void createArrays() {

        // Create lists depending on item selected
        sortedList1 = generateSortedList(selectedArraySize);
        randomList1 = generateRandomList(selectedArraySize);
        inverseList1 = generateInverseList(selectedArraySize);
        sortedList2 = sortedList1.clone();
        randomList2 = randomList1.clone();
        inverseList2 = inverseList1.clone();
        sortedList3 = sortedList1.clone();
        randomList3 = randomList1.clone();
        inverseList3 = inverseList1.clone();
        sortedList4 = sortedList1.clone();
        randomList4 = randomList1.clone();
        inverseList4 = inverseList1.clone();
    }

    public void setButtonEnabled(boolean value) {
        // Allow user to click button
        btnBubbleOrg.setEnabled(value);
        btnBubbleEnh.setEnabled(value);
        btnSelection.setEnabled(value);
        btnInsertion.setEnabled(value);
    }

    /**
     * Loops through passed in array print
     * each element out separated by a comma
     * @param list list to be printed out
     */
    public void printList(int[] list, String message) {

        System.out.print("\nList " + message + ": ");

        for(int i : list)
            System.out.print(list[i] + ", ");

        System.out.println();
    }

    // Main Method
    public static void main(String [] args) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

}
package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI extends JFrame{
    private JTextArea textAreaList1;
    private JTextArea textAreaList2;
    private JTextArea textAreaRes;
    private JPanel panelGUI;
    private JButton buttonJoin;

    public GUI(){
        setContentPane(panelGUI);
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaRes.setText("");
                MyLinkedList list1 = stringToMyLinkedList(textAreaList1.getText());
                MyLinkedList list2 = stringToMyLinkedList(textAreaList2.getText());
                if (list1.isSorted() && list2.isSorted()){
                    MyLinkedList listRes = MyLinkedList.joinSortedMyLists(list1,list2);
                    for (int i = 0; i < listRes.size(); i++) {
                        textAreaRes.append(listRes.get(i) + ", ");
                    }
                }else {
                    textAreaRes.append("Один из листов не отсортирован");
                }
            }
        });
    }
    public List<Integer> stringToList(String str){
        int[] arr = (Arrays.stream(str.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    public MyLinkedList stringToMyLinkedList(String str){
        int[] arr = (Arrays.stream(str.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray());
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }


}

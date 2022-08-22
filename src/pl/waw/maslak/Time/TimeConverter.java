package pl.waw.maslak.Time;
/**
 *
 * @author maslak
 */
import java.awt.*;
import java.awt.event.*;

class TimeConverter extends Frame {

    Label labStdDate = new Label("yyyy-mm-dd hh:mm:ss");
    Label labUxDate = new Label("Unix Timestamp");
    TextField textStdDate = new TextField();
    TextField textUxDate = new TextField();

    Button butt = new Button("Convert");
    Button usun1 = new Button("clear");
    Button usun2 = new Button("clear");

    MenuBar mb = new MenuBar();
    Menu menuFile = new Menu("File");
    MenuItem itemExit = new MenuItem("Exit");
    Menu menuFormat = new Menu("Convert");
    MenuItem itemStdDate = new MenuItem("from dd-mm-yyyy hh:mm:ss");
    MenuItem itemUxDate = new MenuItem("from Unix timestamp");
    Menu menuTools = new Menu("Tools");
    MenuItem itemNow = new MenuItem("Now");

    Panel panelUp = new Panel();

    TimeConvert tc = new TimeConvert();

    public TimeConverter() {
        this.setSize(240, 270);
        this.setBackground(Color.lightGray);
        this.setTitle("TimeConverter");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textStdDate.getText().length() > 0) {
                    textUxDate.setText(String.valueOf(tc.Convert(textStdDate.getText())));
                } else if (textUxDate.getText().length() > 0) {
                    textStdDate.setText(tc.Convert(Long.parseLong(textUxDate.getText())));
                }
            }
        });
        usun1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textStdDate.setText("");
            }
        });
        usun2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUxDate.setText("");
            }
        });
        usun1.setSize(30, 30);
        panelUp.setLayout(new GridLayout(10, 2));
        this.add(panelUp, BorderLayout.NORTH);
        panelUp.add(labStdDate);
        panelUp.add(textStdDate);
        panelUp.add(usun1);
        panelUp.add(labUxDate);
        panelUp.add(textUxDate);
        panelUp.add(usun2);
        panelUp.add(new Label(" "));
        panelUp.add(butt);
        mb.add(menuFile);
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuFile.add(itemExit);
        menuFormat.add(itemStdDate);
        itemStdDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUxDate.setText(String.valueOf(tc.Convert(textStdDate.getText())));
            }
        });
        menuFormat.add(itemUxDate);
        itemUxDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textStdDate.setText(tc.Convert(Long.parseLong(textUxDate.getText())));
            }
        });
        mb.add(menuFormat);
        menuTools.add(itemNow);
        itemNow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUxDate.setText(String.valueOf(System.currentTimeMillis() / 1000));
                textStdDate.setText(tc.Convert(Long.parseLong(textUxDate.getText())));
            }
        });
        mb.add(menuTools);
        this.setMenuBar(mb);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TimeConverter timeConverter = new TimeConverter();
    }
}

package College.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChatBotGUI extends JFrame {

    private JPanel messagesPanel;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JButton sendButton;
    private JPanel quickQuestionsPanel;

    private final String[] quickQuestions = {
            "Establishment Date", "Location", "Hostels", "NBA Accreditation",
            "Committees", "Fees", "Courses Offered", "Faculty"
    };

    // Typing bubble panel reference
    private JPanel typingBubble = null;

    public ChatBotGUI() {
        setTitle("AIMT  Chat");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Main container panel
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.WHITE);
        setContentPane(container);

        // Header
        JLabel header = new JLabel("AIMT Chatbot", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setBorder(new EmptyBorder(10, 10, 10, 10));
        container.add(header, BorderLayout.NORTH);

        // Messages panel inside scroll pane
        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(messagesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        container.add(scrollPane, BorderLayout.CENTER);

        // Bottom input area (input + send + quick questions)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPanel.setBackground(Color.WHITE);

        // Input row (text field + send button)
        JPanel inputRow = new JPanel(new BorderLayout(8, 0));
        inputRow.setBackground(Color.WHITE);

        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        inputField.setPreferredSize(new Dimension(0, 40));
        inputRow.add(inputField, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sendButton.setBackground(new Color(24, 119, 242));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inputRow.add(sendButton, BorderLayout.EAST);

        bottomPanel.add(inputRow, BorderLayout.NORTH);

        // Quick questions panel with horizontal scroll
        quickQuestionsPanel = new JPanel();
        quickQuestionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
        quickQuestionsPanel.setBackground(Color.WHITE);

        for (String q : quickQuestions) {
            JButton btn = new JButton(q);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            btn.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.addActionListener(e -> {
                addUserMessage(q);
                botResponse(q);
            });
            quickQuestionsPanel.add(btn);
        }

        // Wrap quick questions panel inside horizontal scroll pane
        JScrollPane quickScroll = new JScrollPane(quickQuestionsPanel,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        quickScroll.setBorder(null);
        quickScroll.getHorizontalScrollBar().setUnitIncrement(10);
        bottomPanel.add(quickScroll, BorderLayout.CENTER);

        container.add(bottomPanel, BorderLayout.SOUTH);

        // Action listeners for sending messages
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        // Initial bot message
        SwingUtilities.invokeLater(() -> addBotMessage("Hello! Ask me anything about Ambalika Institute or choose a quick question below."));
    }

    private void sendMessage() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            addUserMessage(text);
            botResponse(text);
            inputField.setText("");
        }
    }

    private void addUserMessage(String message) {
        addMessage(message, true);
    }

    private void addBotMessage(String message) {
        addMessage(message, false);
    }

    private void addMessage(String message, boolean isUser) {
        JPanel messageBubble = new JPanel();
        messageBubble.setLayout(new BorderLayout());
        messageBubble.setBackground(isUser ? new Color(24, 119, 242) : new Color(240, 240, 240));
        messageBubble.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel messageLabel = new JLabel("<html>" + message.replace("\n", "<br>") + "</html>");
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageLabel.setForeground(isUser ? Color.WHITE : Color.BLACK);

        messageBubble.add(messageLabel, BorderLayout.CENTER);

        // Container panel for alignment
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new FlowLayout(isUser ? FlowLayout.RIGHT : FlowLayout.LEFT, 10, 5));
        wrapper.setBackground(Color.WHITE);
        wrapper.add(messageBubble);

        // Rounded corners for bubble
        messageBubble.setOpaque(true);
        messageBubble.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(isUser ? new Color(24, 119, 242) : new Color(230, 230, 230), 1),
                new RoundedBorder(15)
        ));

        messagesPanel.add(wrapper);
        messagesPanel.revalidate();
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }

    private void botResponse(String query) {
        String q = query.toLowerCase();
        String response;

        switch (q) {
            case "establishment date":
                response = "Ambalika Institute of Management and Technology was established in 2010.";
                break;
            case "location":
                response = "Located in Lucknow, Uttar Pradesh, India.";
                break;
            case "hostels":
                response = "Separate hostels for boys and girls with modern facilities.";
                break;
            case "nba accreditation":
                response = "B.Tech Computer Science is NBA accredited.";
                break;
            case "committees":
                response = "We have committees like Admission, Anti-Ragging, Placement, Cultural and more.";
                break;
            case "fees":
                response = "The approximate annual tuition fee for B.Tech is ₹ 1,04,500.";
                break;
            case "courses offered":
                response = "We offer B.Tech, MBA, and Diploma courses.";
                break;
            case "faculty":
                response = "We have 124 faculty members with 32 PhDs.";
                break;

                case "establishment?":
                    response = "AIMT was established in 2006.";
                    break;
                case "location?":
                    response = "AIMT is located in Lucknow, Uttar Pradesh, India.";
                    break;
                case "affiliation?":
                    response = "AIMT is affiliated with Dr. A.P.J. Abdul Kalam Technical University (AKTU), Lucknow.";
                    break;
                case "aicte approved?":
                    response = "Yes, AIMT has approval from AICTE for its programs.";
                    break;
                case "programs?":
                    response = "AIMT offers B.Tech, MBA, and Diploma programs.";
                    break;
                case "vision?":
                    response = "To nourish students and blossom them into world-class professionals and good human beings with sincerity, integrity, and social ethics.";
                    break;
                case "mission?":
                    response = "AIMT’s mission includes providing excellent infrastructure, bridging academic-industry gaps, promoting co-curricular activities, and molding responsible citizens.";
                    break;

                case "b.tech fee?":
                    response = "₹89,209 per annum.";
                    break;
                case "mba fee?":
                    response = "₹89,749 per annum.";
                    break;
                case "enrollment fee?":
                    response = "No, these fees are charged separately as per AKTU norms.";
                    break;
                case "hostel fee?":
                    response = "Yes, hostel fee is separate and must be paid annually.";
                    break;
                case "caution money?":
                    response = "No, caution money is excluded from the hostel fee.";
                    break;
                case "hostel fee timing?":
                    response = "At the time of admission.";
                    break;
                case "refund policy?":
                    response = "No, fees are generally non-refundable except caution money after course completion.";
                    break;
                case "caution refund?":
                    response = "After successful completion of the course.";
                    break;

                case "exam norms?":
                    response = "AIMT follows the examination norms set by AKTU.";
                    break;
                case "training fee?":
                    response = "No, it is optional as per college norms.";
                    break;
                case "exam frequency?":
                    response = "As per the AKTU academic calendar.";
                    break;
                case "co-curricular?":
                    response = "Yes, co-curricular and extracurricular activities are promoted to enhance student skills.";
                    break;

                case "library?":
                    response = "Yes, AIMT has a well-equipped library.";
                    break;
                case "hostels?":
                    response = "Yes, separate hostels are available for boys and girls.";
                    break;
                case "sports?":
                    response = "Yes, various sports facilities are available.";
                    break;
                case "medical?":
                    response = "Yes, medical facilities and support are provided.";
                    break;
                case "ict?":
                    response = "Yes, AIMT has adequate Information and Communication Technology facilities.";
                    break;

                case "faculty count?":
                    response = "AIMT has a total of 124 faculty members.";
                    break;
                case "phd faculty?":
                    response = "32 faculty members hold PhDs.";
                    break;
                case "research papers?":
                    response = "Faculty members have published 325 research papers.";
                    break;
                case "research focus?":
                    response = "Yes, AIMT actively encourages research and development activities.";
                    break;

                case "committees?":
                    response = "Purchase, Security, Admission, Proctorial Board, Anti-Ragging, Internal Complaint, Grievance Redressal, Website, Maintenance, Hostel, Finance, Academic & Examination, Research & Development, Placement, Personality Development, Library, Technical Training, Sports, Cultural, and NEP Committee.";
                    break;
                case "student role?":
                    response = "Yes, students are involved in various committees to develop leadership and responsibility.";
                    break;
                case "anti-ragging?":
                    response = "Ensures a ragging-free environment on campus.";
                    break;
                case "placement committee?":
                    response = "Organizes campus placements and prepares students for job opportunities.";
                    break;

                case "nba accredited?":
                    response = "Yes, AIMT’s B.Tech Computer Science program is NBA accredited.";
                    break;
                case "approval 2024-25?":
                    response = "Yes, AICTE and AKTU have extended approval for the academic year 2024–25.";
                    break;

                case "admission process?":
                    response = "Through the admission process as per AKTU and college guidelines.";
                    break;
                case "admission committee?":
                    response = "Yes, AIMT has a dedicated Admission Committee.";
                    break;
                case "eligibility?":
                    response = "As per AKTU norms, typically requiring completion of 12th standard with required subjects.";
                    break;

                case "accommodation?":
                    response = "Yes, separate hostels for boys and girls are available.";
                    break;
                case "hostel facilities?":
                    response = "Fooding and lodging charges are included.";
                    break;


                case "placement cell?":
                    response = "Yes, AIMT has an active Placement Committee.";
                    break;
                case "personality development?":
                    response = "Yes, AIMT organizes personality development activities.";
                    break;
                case "recruiters?":
                    response = "Various reputed companies from IT, manufacturing, and other sectors participate in campus placements.";
                    break;

                case "sports & culture?":
                    response = "Yes, AIMT has Sports and Cultural Committees to organize events.";
                    break;
                case "technical training?":
                    response = "Yes, AIMT offers technical training through its Technical Training Committee.";
                    break;

                case "campus area?":
                    response = "AIMT campus covers a substantial area (exact size can be specified if needed).";
                    break;
                case "classrooms?":
                    response = "AIMT has adequate classrooms equipped with modern teaching aids.";
                    break;

                case "governance?":
                    response = "AIMT is governed by a Board of Governors including academicians and industry experts.";
                    break;
                case "finance committee?":
                    response = "Yes, AIMT has a Finance Committee to manage funds and expenditures.";
                    break;
                case "academic committee?":
                    response = "Yes, AIMT has an Academic & Examination Committee.";
                    break;

                case "complaint committee?":
                    response = "Yes, for addressing complaints related to harassment and misconduct.";
                    break;
                case "grievance committee?":
                    response = "Yes, AIMT has a committee to address student grievances promptly.";
                    break;

                case "nep committee?":
                    response = "Yes, there is an NEP Committee for implementation of National Education Policy reforms.";
                    break;

                case "financial reports?":
                    response = "Yes, the institute maintains transparency by sharing financial reports.";
                    break;

                case "training & development?":
                    response = "Optional Training & Development programs are available.";
                    break;
                case "co-curricular support?":
                    response = "Strongly encouraged to develop well-rounded professionals.";
                    break;
                case "fee refund?":
                    response = "Fees are non-refundable except caution money after course completion.";
                    break;
                case "fee revision?":
                    response = "Fees are as per AKTU norms but may be revised periodically.";
                    break;
                case "quality assurance?":
                    response = "Through qualified faculty, NBA accreditation, research, and continuous evaluation.";
                    break;
                case "student committees?":
                    response = "Participation encouraged.";
                    break;
                case "overall development?":
                    response = "Academic, technical, cultural, sports, and personality development activities.";
                    break;
                case "instruction medium?":
                    response = "English is the primary medium of instruction.";
                    break;
                case "website?":
                    response = "Yes, AIMT maintains an official website for updates and information.";
                    break;
                case "industry collaboration?":
                    response = "Collaborates for training and placement opportunities.";
                    break;
                case "extracurricular activities?":
                    response = "Cultural events, sports tournaments, technical fests, personality programs.";
                    break;
                case "transport?":
                    response = "May be available; confirm with institute.";
                    break;
                case "scholarships?":
                    response = "Available as per government or college policies.";
                    break;
                case "faculty research?":
                    response = "Faculty actively involved, publishing over 325 papers.";
                    break;
                case "ragging prevention?":
                    response = "Strict policies and Anti-Ragging Committee in place.";
                    break;

                case "purchase committee?":
                    response = "Manages procurement of materials and equipment.";
                    break;
                case "security committee?":
                    response = "Ensures campus safety.";
                    break;
                case "maintenance committee?":
                    response = "Oversees infrastructure upkeep.";
                    break;
                case "website committee?":
                    response = "Manages online presence and website.";
                    break;
                case "proctorial board?":
                    response = "Mentors students and maintains discipline.";
                    break;

                case "postgraduate faculty?":
                    response = "77 faculty members.";
                    break;
                case "undergraduate faculty?":
                    response = "15 faculty members.";
                    break;

                case "computer labs?":
                    response = "Yes, fully equipped.";
                    break;
                case "internet?":
                    response = "High-speed internet available.";
                    break;
                case "air-conditioning?":
                    response = "Some classrooms have modern amenities.";
                    break;

                case "library committee?":
                    response = "Yes, manages library services.";
                    break;
                case "grievance mechanism?":
                    response = "Yes, Students Grievance Redressal Committee.";
                    break;
                case "medical facilities?":
                    response = "Available on campus.";
                    break;

                case "internships?":
                    response = "Facilitated via Placement and Training Committee.";
                    break;
                case "industrial visits?":
                    response = "Organized to provide practical exposure.";
                    break;
                case "faculty development programs?":
                    response = "Regular FDPs are conducted.";
                    break;
            case "ok":
                response = "ok....BYE...";
                break;

                // Add more cases here as needed...



            default:
                response = "Sorry, I didn't get that. Please ask another question or select one below.";
        }

        addTypingBubble();

        // After delay, remove typing and add the response
        Timer timer = new Timer(1500, e -> {
            removeTypingBubble();
            addBotMessage(response);
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Add typing bubble
    private void addTypingBubble() {
        typingBubble = new JPanel();
        typingBubble.setLayout(new BorderLayout());
        typingBubble.setBackground(new Color(240, 240, 240));
        typingBubble.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel typingLabel = new JLabel("Typing...");
        typingLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        typingLabel.setForeground(Color.GRAY);

        typingBubble.add(typingLabel, BorderLayout.CENTER);

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        wrapper.setBackground(Color.WHITE);
        wrapper.add(typingBubble);

        messagesPanel.add(wrapper);
        messagesPanel.revalidate();

        // Scroll down to bottom
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }

    // Remove typing bubble
    private void removeTypingBubble() {
        if (typingBubble != null) {
            Container parent = typingBubble.getParent();
            if (parent != null) {
                messagesPanel.remove(parent);
                messagesPanel.revalidate();
                messagesPanel.repaint();
            }
            typingBubble = null;
        }
    }

    // Custom border class for rounded corners on JPanel
    static class RoundedBorder implements javax.swing.border.Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.GRAY);
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatBotGUI();
        });
    }
}

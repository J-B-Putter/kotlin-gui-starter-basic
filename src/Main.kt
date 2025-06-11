/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.Color.GREEN
import java.awt.Color.MAGENTA
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var textBox: JTextField


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(700, 500)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Hello, World!")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50,300,250,100)
        helloButton.addActionListener(this)     // Handle any clicks
        helloButton.font = defaultFont
        helloButton.foreground = Color.YELLOW
        helloButton.background = Color(0,33,66)
        add(helloButton)

        goodbyeButton = JButton("Good bye!")
        goodbyeButton.bounds = Rectangle(400,300,250,100)
        goodbyeButton.addActionListener(this)     // Handle any clicks
        goodbyeButton.font = defaultFont
        goodbyeButton.foreground = Color.YELLOW
        goodbyeButton.background = Color(0,33,66)
        add(goodbyeButton)

        textBox = JTextField()
        textBox.font = defaultFont
        textBox.addActionListener(this)
        textBox.addKeyListener(this)
        textBox.bounds = Rectangle(50,150,600,100)
        add(textBox)

    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        var sName = if (textBox.text.isBlank()) "Stranger" else textBox.text

        when (e?.source) {
            textBox -> {
                println("Changed textBox.text to ${textBox.text}")
            }
            helloButton -> {
                println("Hello button pressed")
                greetingLabel.foreground = Color.GREEN
                greetingLabel.text = "Hello, ${sName}!"
            }
            goodbyeButton -> {
                println("Goodbye button pressed")
                greetingLabel.foreground = Color.ORANGE
                greetingLabel.text = "Goodbye, $sName!"
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key typed: ${e?.keyChar}")

    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key pressed: ${e?.keyCode}")
//        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
//            greetingLabel.text = "You pressed ${e?.keyChar}"
//        }
        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("letter key!!")
        }
        else e?.consume()

    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key released: ${e?.keyCode}")

    }

}


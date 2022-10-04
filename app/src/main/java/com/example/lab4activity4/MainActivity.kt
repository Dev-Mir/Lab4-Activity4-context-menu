package com.example.lab4activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {

//    lateinit var Button btn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    popup_Menu();

    }

    private  fun popup_Menu(){
        val btn = findViewById<Button>(R.id.btnId)
        val popupMenu = PopupMenu(applicationContext, btn )
        popupMenu.inflate(R.menu.popmenuitem)
        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.contextmenu->{
                    Toast.makeText(applicationContext, "context Menu", Toast.LENGTH_SHORT).show()
                    true;
                }

                R.id.upload->{
                    Toast.makeText(applicationContext, "uploaded", Toast.LENGTH_SHORT).show()
                    true;
                }



                R.id.search->{
                    Toast.makeText(applicationContext, "Searched", Toast.LENGTH_SHORT).show()
                    true;
                }

                R.id.share->{
                    Toast.makeText(applicationContext, "shared", Toast.LENGTH_SHORT).show()
                    true;
                }

                R.id.bookmark->{
                    Toast.makeText(applicationContext, "Bookmarked", Toast.LENGTH_SHORT).show()
                    true;
                }
                else -> {true}
            }
        }

        btn.setOnLongClickListener {

            try {
                val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true
                val menu = popup.get(popupMenu)
                menu.javaClass
                    .getDeclaredMethod("setforceshowicon", Boolean::class.java)
                    .invoke(menu, true)
            } catch (e: Exception){
                e.printStackTrace()
            }
            finally {
                popupMenu.show()
            }
            true
        }
    }

}
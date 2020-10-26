package com.example.fundamentals

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

class Dialogs(var context: Context) {

    fun Dialog1() {
        val addcontactdialog1 = AlertDialog.Builder(context)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr. Poop ?")
            .setIcon(R.drawable.ic_add_person1)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(context, "Added contact succesfully", Toast.LENGTH_SHORT).show()
            }.setNegativeButton("No") { _, _ ->
                Toast.makeText(context, "Cancelled adding contact", Toast.LENGTH_SHORT).show()
            }.create()

        addcontactdialog1.show()
    }

    fun Dialog2() {
        val list = arrayOf("Mumbai Indians", "Chennai Super Kings", "Royal challengers bangalore")

        val optiondialog = AlertDialog.Builder(context)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(list, 0) { _, i ->
                Toast.makeText(context, "You clicked on ${list[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, i ->
                Toast.makeText(context, "You Accepted ", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(context, "You Declined", Toast.LENGTH_SHORT).show()
            }.create()

        optiondialog.show()
    }

    fun Dialog3() {
        val list1 = arrayOf("Harry Potter", "Lord Of The Rings", "Big Bang Theory", "Young Sheldon")
        val bool = booleanArrayOf(false, false, false, false)

        val multichdilog = AlertDialog.Builder(context)
            .setTitle("Choose from these options")
            .setMultiChoiceItems(list1, bool) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(context, "You Checked ${list1[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "You Unchecked ${list1[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, i ->
                Toast.makeText(context, "You Accepted ", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(context, "You Declined", Toast.LENGTH_SHORT).show()
            }.create()

        multichdilog.show()
    }
}
package com.ladoshko.chatikk.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ladoshko.chatikk.R
import com.ladoshko.chatikk.ui.fragments.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(val mainActivity: AppCompatActivity, val toolbar: Toolbar) {

    private lateinit var mDrawer : Drawer
    private lateinit var mHeader: AccountHeader

    fun create(){
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem()
                    .withIdentifier(100)
                    .withIconTintingEnabled(false)
                    .withName("Создать группу")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_create_group),
                PrimaryDrawerItem()
                    .withIdentifier(101)
                    .withIconTintingEnabled(false)
                    .withName("Создать секретный чат")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_secret_chat),
                PrimaryDrawerItem()
                    .withIdentifier(102)
                    .withIconTintingEnabled(false)
                    .withName("Создать канал")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_add_chanel),
                PrimaryDrawerItem()
                    .withIdentifier(103)
                    .withIconTintingEnabled(false)
                    .withName("Контакты")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_contacts),
                PrimaryDrawerItem()
                    .withIdentifier(104)
                    .withIconTintingEnabled(false)
                    .withName("Звонки")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_call),
                PrimaryDrawerItem()
                    .withIdentifier(105)
                    .withIconTintingEnabled(false)
                    .withName("Избранное")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_favourite),
                PrimaryDrawerItem()
                    .withIdentifier(106)
                    .withIconTintingEnabled(false)
                    .withName("Настройки")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_settings),
                DividerDrawerItem(),
                PrimaryDrawerItem()
                    .withIdentifier(107)
                    .withIconTintingEnabled(false)
                    .withName("Пригласить друзей")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_person_add),
                PrimaryDrawerItem()
                    .withIdentifier(108)
                    .withIconTintingEnabled(false)
                    .withName("Вопросы")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_questions),

                ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener{
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when(position){
                        7 -> mainActivity.supportFragmentManager.beginTransaction().addToBackStack(null)
                            .replace(R.id.data_container, SettingsFragment()).commit()
                    }
                    return false
                }
            })
            .build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder().withActivity(mainActivity).withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("KSU")
                    .withEmail("+380987380889")
            ).build()
    }

}
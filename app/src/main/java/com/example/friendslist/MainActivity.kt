package com.example.friendslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




data class Friend(
    val name: String,
    val email: String,
    val address: String,
    @DrawableRes val photoResId: Int
)

val friendsList = listOf(
    Friend("Abid Falihaqil", "Helperbid1@gmail.com", "Jl Provinsi, Kartama, Marpoyan Damai", R.drawable.abid),
    Friend("Adjie Putra Ramdhani", "adjieramdhani4@gmail.com", "Jl. Beringin-Air Hitam, Gg. Ar-Rahman, Sungai Sibam, Tapung", R.drawable.adjie),
    Friend("Aris Fadhila", "arisfadhila@gmail.com", "Jl.Manunggal,Rimbo Panjang", R.drawable.aris),
    Friend("Ela Melina", "elamelina7777@gmail.com", "Jl. Mawar, Simpang Baru, Tampan", R.drawable.ela),
    Friend("Farhan Arfazi", "farhanarfazi7@gmail.com", "Jl Cempaka, Gg Sekuntum No. 6", R.drawable.farhan),
    Friend("Hairunisha", "hairunisha76@gmail.com", "Jl.Rimbong Panjang Tambang", R.drawable.nisa),
    Friend("Irvandi Ramadhan Abbas", "Vandigtg99@gmail.com", "Jl Rimbo panjang, Gg Asta karya, Tambang", R.drawable.vandi),
    Friend("Muhammad Al Ghifary Afisha", "12350111885@students.uin-suska.ac.id", "Jl, Rimba Panjang, Pekanbaru-Bangkinang, Kabupaten Kampar, Riau 28468", R.drawable.agip),
    Friend("M.Qodratul Qudus", "mqudri2005@gmail.com", "Jl.Andalas, Sidomulyo Barat, Tampan", R.drawable.odi),
    Friend("Nadya Halliza", "nadyahalliza.9h@gmail.com", "Jl. Ahmad Dahlan, Tambusai, Rumbio Jaya, Kampar", R.drawable.nadya),
    Friend("Naufal Affandi", "samuelsatria@gmail.com", "Jl. Garuda sakti, Jln. Satria, Kel. Simpang Baru, Tampan", R.drawable.naufal),
    Friend("Naya Nabila", "nayaanabila20@gmail.com", "Jl. Taman Karya, Perum. Permata Bunda 1, Tampan", R.drawable.naya),
    Friend("Nisha Rahmadini Syahda", "nishasyahda@gmail.com", "Jalan Kruing 2 Pandau Permai", R.drawable.syahda),
    Friend("Noval Adiya Putra", "novaladiyaputra@gmail.com", "Jl.Sukakarya, Tuah Karya, Tampan", R.drawable.noval),
    Friend("Rafinaldi", "rafinaldi05@gmail.com", "Jl. Melur, Sidomulyo Barat, Tampan", R.drawable.rafi),
    Friend("Rijan Ananta", "rijanananta09@gmail.com", "Jl. Garuda sakti, Jln. Satria, Kel. Simpang Baru, Tampan", R.drawable.rijan),
    Friend("Rizky Syakuur Rahman", "rizkysyakuurrahman18@gmail.com", "Jl.Sepakat, Garuda Sakti KM 1,5, Kel.Simpang Baru, Kec. Tampan, Prov.Riau", R.drawable.sakur),
    Friend("Salsabillah Amalia Al Hadi", "Salsabillahamalia3@gmail.com", "Jl. Perumahan Vaishatamma, Jl. Anggrek No.11, RT.006/RW.016, Desa Rawang Air Putih, Kec. Tampan, Kota Pekanbaru, Riau 28293", R.drawable.salsa),
    Friend("Tengku Ipo Rasya Abadi", "tengkuiporasya@gmail.com", "Jl. Suka Karya, Perumahan Laucih", R.drawable.ipo),
    Friend("Vinicius jr", "vinicius@gmail.com", "Jl. Manunggal", R.drawable.vini)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendsListScreen()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendsListScreen() {
    Scaffold(
        topBar = {
            TopAppBar (title = { Text("Super Friends") })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(friendsList) { friend ->
                FriendItem(friend)
            }
        }
    }
}

@Composable
fun FriendItem(friend: Friend) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(friend.photoResId),
                contentDescription = "Friend Photo",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = friend.name, style = MaterialTheme.typography.titleLarge)
                Text(text = friend.email, style = MaterialTheme.typography.bodyMedium)
                Text(text = friend.address, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFriendsList() {
    FriendsListScreen()
}

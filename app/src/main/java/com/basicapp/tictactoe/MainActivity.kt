package com.basicapp.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basicapp.tictactoe.ui.theme.TictactoeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TictactoeTheme {
                val player1 = remember { mutableStateOf("") }
                val player2 = remember { mutableStateOf("") }
                val gameStarted = remember { mutableStateOf(false) }
                if (!gameStarted.value) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        TextField(value = player1.value, onValueChange = { player1.value = it }, label = { Text("Player 1 Name") })
                        TextField(value = player2.value, onValueChange = { player2.value = it }, label = { Text("Player 2 Name") })
                        Button(onClick = { if (player1.value.isNotBlank() && player2.value.isNotBlank()) gameStarted.value = true }) {
                            Text("Start Game")
                        }
                    }
                } else {
                    TicTacToeBoard(player1, player2, gameStarted)
                }


            }
        }
    }
}

@Composable
fun TicTacToeBoard(player1: MutableState<String>,
                   player2: MutableState<String>,
                   gameStarted: MutableState<Boolean>,modifier: Modifier = Modifier) {
    var turn= remember { mutableStateOf(true) }
    var box1= remember { mutableStateOf(0) }
    var box2= remember { mutableStateOf(0) }
    var box3= remember { mutableStateOf(0) }
    var box4= remember { mutableStateOf(0) }
    var box5= remember { mutableStateOf(0) }
    var box6= remember { mutableStateOf(0) }
    var box7= remember { mutableStateOf(0) }
    var box8= remember { mutableStateOf(0) }
    var box9= remember { mutableStateOf(0) }

    var string_player by remember { mutableStateOf("") }
    string_player = if (turn.value) player1.value else player2.value

    val cond1=remember { mutableStateOf(false)}
    val cond2=remember { mutableStateOf(false)}
    if(box1.value==1 && box2.value==1 && box3.value==1){
        cond1.value=true
    }
    else if(box4.value==1 && box5.value==1 && box6.value==1){
        cond1.value=true
    }
    else if(box7.value==1 && box8.value==1 && box9.value==1){
        cond1.value=true
    }
    else if(box1.value==1 && box4.value==1 && box7.value==1){cond1.value=true}
    else if(box2.value==1 && box5.value==1 && box8.value==1){cond1.value=true}
    else if(box3.value==1 && box6.value==1 && box9.value==1){cond1.value=true}
    else if(box1.value==1 && box5.value==1 && box9.value==1){cond1.value=true}
    else if(box3.value==1 && box5.value==1 && box7.value==1){cond1.value=true}

    if(box1.value==2 && box2.value==2 && box3.value==2){
        cond2.value=true
    }
    else if(box4.value==2 && box5.value==2 && box6.value==2){
        cond2.value=true
    }
    else if(box7.value==2 && box8.value==2 && box9.value==2){
        cond2.value=true
    }
    else if(box1.value==2 && box4.value==2 && box7.value==2){cond2.value=true}
    else if(box2.value==2 && box5.value==2 && box8.value==2){cond2.value=true}
    else if(box3.value==2 && box6.value==2 && box9.value==2){cond2.value=true}
    else if(box1.value==2 && box5.value==2 && box9.value==2){cond2.value=true}
    else if(box3.value==2 && box5.value==2 && box7.value==2){cond2.value=true}

    if (cond1.value) string_player = player1.value + " Won"
    else if (cond2.value) string_player = player2.value + " Won"




    Column(modifier.fillMaxSize().padding(16.dp)
    , horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.SpaceEvenly
    ) {
    Row(modifier=Modifier
        .background(color = Color.Cyan)) {
        Text(
            text = string_player,
            fontSize = 30.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
    Column(modifier = modifier.background(Color.Gray)
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if (box1.value==0 && !cond1.value && !cond2.value){box1.value=if (turn.value) 1 else 2
                if(turn.value) turn.value=false else turn.value=true}
                }
            )
            {
                if (box1.value!=0){
                    val id1:Int;
                    if (box1.value==1){
                    id1=R.drawable.o}
                    else{
                        id1=R.drawable.x
                    }
                    Image(painter = painterResource(id = id1), contentDescription = null)
                }
        }

        Box(modifier = Modifier
            .height(100.dp).width(100.dp)
            .clickable{if(box2.value==0 && !cond1.value && !cond2.value){box2.value=if (turn.value) 1 else 2
                if(turn.value) turn.value=false else turn.value=true}}
        )
        {
            if (box2.value!=0){
                val id2:Int;
                if (box2.value==1){
                    id2=R.drawable.o}
                else{
                    id2=R.drawable.x
                }
                Image(painter = painterResource(id = id2), contentDescription = null)
            }
        }
        Box(modifier = Modifier
            .height(100.dp).width(100.dp)
            .clickable{if (box3.value==0 && !cond1.value && !cond2.value){box3.value=if (turn.value) 1 else 2
                if(turn.value) turn.value=false else turn.value=true}}
        )
        {
            if (box3.value!=0){
                val id3:Int;
                if (box3.value==1){
                    id3=R.drawable.o}
                else{
                    id3=R.drawable.x
                }
                Image(painter = painterResource(id = id3), contentDescription = null)
            }
        }
    }

        Row {
            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if(box4.value==0 && !cond1.value && !cond2.value){box4.value=if (turn.value) 1 else 2
                    if(turn.value) turn.value=false else turn.value=true}}
            )
            {
                if (box4.value!=0){
                    val id4:Int;
                    if (box4.value==1){
                        id4=R.drawable.o}
                    else{
                        id4=R.drawable.x
                    }
                    Image(painter = painterResource(id = id4), contentDescription = null)
                }
            }

            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if(box5.value==0 && !cond1.value && !cond2.value){box5.value=if (turn.value) 1 else 2
                    if(turn.value) turn.value=false else turn.value=true}}
            )
            {
                if (box5.value!=0){
                    val id5:Int;
                    if (box5.value==1){
                        id5=R.drawable.o}
                    else{
                        id5=R.drawable.x
                    }
                    Image(painter = painterResource(id = id5), contentDescription = null)
                }
            }
            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if(box6.value==0 && !cond1.value && !cond2.value){box6.value=if (turn.value) 1 else 2
                    if(turn.value) turn.value=false else turn.value=true}}
            )
            {
                if (box6.value!=0){
                    val id6:Int;
                    if (box6.value==1){
                        id6=R.drawable.o}
                    else{
                        id6=R.drawable.x
                    }
                    Image(painter = painterResource(id = id6), contentDescription = null)
                }
            }
        }

        Row {
            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if(box7.value==0 && !cond1.value && !cond2.value){box7.value=if (turn.value) 1 else 2
                    if(turn.value) turn.value=false else turn.value=true}})

            {
                if (box7.value!=0){
                    val id7:Int;
                    if (box7.value==1){
                        id7=R.drawable.o}
                    else{
                        id7=R.drawable.x
                    }
                    Image(painter = painterResource(id = id7), contentDescription = null)
                }
            }

            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if(box8.value==0 && !cond1.value && !cond2.value){box8.value=if (turn.value) 1 else 2
                    if(turn.value) turn.value=false else turn.value=true}}
            )
            {
                if (box8.value!=0){
                    val id8:Int;
                    if (box8.value==1){
                        id8=R.drawable.o}
                    else{
                        id8=R.drawable.x
                    }
                    Image(painter = painterResource(id = id8), contentDescription = null)
                }
            }
            Box(modifier = Modifier
                .height(100.dp).width(100.dp)
                .clickable{if(box9.value==0 && !cond1.value && !cond2.value){box9.value=if (turn.value) 1 else 2
                    if(turn.value) turn.value=false else turn.value=true}}
            )
            {
                if (box9.value!=0){
                    val id9:Int;
                    if (box9.value==1){
                        id9=R.drawable.o}
                    else{
                        id9=R.drawable.x
                    }
                    Image(painter = painterResource(id = id9), contentDescription = null)
                }
            }
        }


    }
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Reset", fontSize = 20.sp, modifier = Modifier
                .background(color = Color.Green)
                .clickable { box1.value=0 ;box2.value=0;box3.value=0;
                    box4.value=0;box5.value=0;box6.value=0;
                    box7.value=0;box8.value=0;box9.value=0;
                    cond1.value=false;cond2.value=false;
                    player1.value = ""
                    player2.value = ""
                    gameStarted.value = false})

        }
}


}


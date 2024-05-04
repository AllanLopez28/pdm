package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.allan.DummyData

@Composable
fun ToDo() {

    val textStateTitle = remember { mutableStateOf("") }
    val textStateDescription= remember { mutableStateOf("") }
    val tasks = remember { mutableStateListOf <DummyData>() }
    Surface(modifier = Modifier.fillMaxSize()) {

        Column {

            Column ( modifier = Modifier
                .fillMaxSize(1.5f)
                .weight(1.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center ) {


                OutlinedTextField(
                    modifier = Modifier
                        .width(300.dp),
                    value = textStateTitle.value,
                    onValueChange = {textStateTitle.value = it},
                    label = { Text("Enter your task") })

                OutlinedTextField(
                    modifier = Modifier
                        .width(300.dp),
                    value = textStateDescription.value,
                    onValueChange = {textStateDescription.value = it},
                    label = { Text("Enter your task") })



                Btntask  {
                    tasks.add(DummyData(textStateTitle.value,textStateDescription.value))

                }


            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
                    .background(color = MaterialTheme.colorScheme.primary)
            ) {

                LazyColumn {
                    itemsIndexed(tasks.toList()) { index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()

                            ) {

                                Spacer(modifier = Modifier.padding(8.dp))
                                Text(
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp),

                                    text = "Nombre de libro: ${item.title}"
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp),


                                    text = "Nombre del Editor: ${item.description}"
                                )
                                Spacer(modifier = Modifier.padding(8.dp))

                                Button(onClick = { tasks.remove(item) }) {
                                    Text("Eliminar tarea")
                                }
                            }
                        }
                    }
                }
            }

        }






    }
}



@Composable
fun Btntask(onCLick: () -> Unit){
    Button(onClick = onCLick,
        modifier = Modifier
            .padding(16.dp)


    ) {
        Text(text = "Añadir tarea")

    }

}


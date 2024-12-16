package com.uvm.tiempoefectivo

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TareaViewModel : ViewModel() {
    private val db = Firebase.firestore

    data class Tarea(
        val descripcion: String = "",
        val fechaLimite: String = "",
        val id: String = "" // Puedes usar un ID autogenerado de Firestore
    )
    // Aquí irán las funciones CRUD
    fun obtenerTareas(onTareasObtenidas: (List<Tarea>) -> Unit) {
        db.collection("tareas")
            .get()
            .addOnSuccessListener { result ->
                val tareas = result.toObjects(Tarea::class.java)
                onTareasObtenidas(tareas)
            }
            .addOnFailureListener { exception ->
                // Manejar el error, por ejemplo, mostrar un mensaje al usuario
                println("Error al obtener las tareas: ${exception.message}")
            }
    }
    fun agregarTarea(tarea: Tarea) {
        db.collection("tareas")
            .add(tarea)
            .addOnSuccessListener { documentReference ->
                // Manejar el éxito, por ejemplo, mostrar un mensaje al usuario
                println("Tarea agregada con ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                // Manejar el error, por ejemplo, mostrar un mensaje al usuario
                println("Error al agregar la tarea: ${e.message}")
            }
    }
    fun actualizarTarea(tarea: Tarea) {
        db.collection("tareas")
            .document(tarea.id) // Asumiendo que la tarea tiene una propiedad 'id'
            .set(tarea)
            .addOnSuccessListener {
                // Manejar el éxito, por ejemplo, mostrar un mensaje al usuario
                println("Tarea actualizada con ID: ${tarea.id}")
            }
            .addOnFailureListener { e ->
                // Manejar el error, por ejemplo, mostrar un mensaje al usuario
                println("Error al actualizar la tarea: ${e.message}")
            }
    }
    fun eliminarTarea(tareaId: String) {
        db.collection("tareas")
            .document(tareaId)
            .delete()
            .addOnSuccessListener {
                // Manejar el éxito, por ejemplo, mostrar un mensaje al usuario
                println("Tarea eliminada con ID: $tareaId")
            }
            .addOnFailureListener { e ->
                // Manejar el error, por ejemplo, mostrar un mensaje al usuario
                println("Error al eliminar la tarea: ${e.message}")
            }
    }
}
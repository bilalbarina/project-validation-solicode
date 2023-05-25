package prototype.todolist

import prototype.todolist.data.TaskDao
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main (){
    println("Programme de Test")
    val taskRepository = TaskRepository()
    // Ajouter une tâche
    println("\nAdding tasks...")
    for (i in 1..5) {
        val task = TaskEntry(0, "Task $i", 1, System.currentTimeMillis())
        taskRepository.save(task);
    }
    println("Tasks added. Count: ${taskRepository.getAllTasks().size}\n")

    // Suprimer une tâche
    println("\nDeleting tasks")
    taskRepository.delete(2)
    println("Tasks deleted. Count: ${taskRepository.getAllTasks().size}\n")


    // Modifier une tâche
    println("\nModifying tasks")
    val task = taskRepository.findById(5)
    task.title = "Modified Task"
    taskRepository.save(task)
    println("Tasks modified\n")

    // Afficher les tâches
    taskRepository.getAllTasks().forEach { println("${it.id} - ${it.title}") }

    println("\nTest finished.")
}
import styles from "./taskManager.module.css";
import mockTaskManager from "./mockTaskManager";
import { useEffect, useState } from "react";

function TaskManager() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    mockTaskManager().then((data: any) => {
      setTasks(data.tasks);
    });
  }, []);

  return (
    <>
      <div className={styles.wrapper}>
        <header>
          <div className={styles.pageBanner}>
            <h1 className={styles.title}>Task Manager</h1>

            <form className={styles.searchTasks}>
              <input type="text" placeholder="Search tasks..." />
            </form>
          </div>
        </header>

        <div className={styles.taskList}>
          <h2 className={styles.title}>Tasks to Do</h2>

          <ul>
            <li>
              <span className={styles.name}>Learn JavaScript</span>
              <span className={styles.delete}>delete</span>
            </li>

            <li>
              <span className={styles.name}>Practice DOM Manipulation</span>
              <span className={styles.delete}>delete</span>
            </li>

            <li>
              <span className={styles.name}>Build a mini project</span>
              <span className={styles.delete}>delete</span>
            </li>

            <li>
              <span className={styles.name}>Revise CSS Flexbox</span>
              <span className={styles.delete}>delete</span>
            </li>
          </ul>
        </div>

        <form className={styles.addTask}>
          <input type="text" placeholder="Add a task..." />
          <button>Add</button>
        </form>
      </div>
    </>
  );
}

export default TaskManager;

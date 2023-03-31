import { Button } from '@mui/material'
import { useEffect, useState } from 'react'
import { Plus } from 'react-feather'
import { ToastContainer, toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import './App.css'
import TodoComponent from './components/todo/TodoComponent'
import { Todo } from './type/Todo'
import TodoFormComponent from "./components/todo_form/TodoFormComponent";

function App() {
  const [todoListData, setTodoListData] = useState<Todo[]>([]);
  const [showForm, setShowForm] = useState<boolean>(false);

  useEffect(() => {
    fetch('http://localhost:3000/api/todo')
    .then(response => response.json())
    .then((data: Todo[]) => setTodoListData(data))
    .catch(error => console.error(error));
  }, [])

  const reloadTodoList = () => {
    fetch('http://localhost:3000/api/todo')
    .then(response => response.json())
    .then((data: Todo[]) => setTodoListData(data))
    .catch(error => {
      console.error(error);
      toast.error("Un probème est survenu, veuillez réessayer")
    });
  }

  const deleteTodo = (todo: Todo) => {
    fetch('http://localhost:3000/api/todo/' + todo.id, {method: 'DELETE'})
  .then(response => {
    if (!response.ok) {
      toast.error("Un problème est survenue lors de la suppression");
    } else {
      toast.dismiss();
      toast.success("Votre Todo \"" + todo.titleTODO + "\" a bien été supprimée");
    }
    reloadTodoList();
  })
      .catch(error => {
        console.error(error);
        toast.error("Un probème est survenu, veuillez réessayer")
      });
  }

  const addTodo = (todoToAdd: Todo) => {
    console.log('add');
    fetch('http://localhost:3000/api/todo/add', { method: 'POST', body: JSON.stringify(todoToAdd),
  headers: {
    'Content-Type': 'application/json'
  } })
      .then(response => response.json())
      .then(() => reloadTodoList())
      .then(() => {
        toast.dismiss();
        toast.success('Nouvelle todo ajoutée !');
        setShowForm(false);
      })
      .catch(error => {
        console.error(error);
        toast.error("Un probème est survenu, veuillez réessayer")
      });
  }

  const checkTodo = (todo: Todo) => {
    fetch('http://localhost:3000/api/todo/' + todo.id + '/check' , { method: 'PATCH'})
      .then(response => response.json())
      .then(() => reloadTodoList())
      .then(() => {
        toast.dismiss();
        toast.success('Done !')
      })
      .catch(error => {
        console.error(error);
        toast.error("Un probème est survenu, veuillez réessayer")
      });
  }

  const unCheckTodo = (todo: Todo) => {
    fetch('http://localhost:3000/api/todo/' + todo.id + '/unCheck' , { method: 'PATCH'})
      .then(response => response.json())
      .then(() => reloadTodoList())
      .then(() => {
        {
          toast.dismiss();
          toast.warning('À faire !');
        }
        }
      )
      .catch(error => {
        console.error(error);
        toast.error("Un probème est survenu, veuillez réessayer")
      });
  }

  return (
    <div className="layout">
      <div className="title">MYTODO APPLICATION</div>
      <div className="todo-list">
        {
          todoListData?.map((todo: Todo) => (
            <TodoComponent
              todo={todo}
              deleteTodo={() => deleteTodo(todo)}
              check={(todo: Todo) => checkTodo(todo)}
              unCheck={(todo: Todo) => unCheckTodo(todo)}
            />
          ))
          }
          <div className="new-todo">
      <Button variant="contained" onClick={() => setShowForm(true)}>
        <Plus />
              <span>Ajouter une tâche</span>
      </Button>
          </div>
      </div>
      <ToastContainer autoClose={1000}/>
      {
        showForm && <TodoFormComponent close={() => setShowForm(false)} addTodo={(todo: Todo) => addTodo(todo) }/>
      }
</div>
  )
}

export default App

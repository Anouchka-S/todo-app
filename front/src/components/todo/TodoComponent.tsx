import { Checkbox } from '@mui/material';
import { Trash2 } from 'react-feather';
import { Todo } from '../../type/Todo'
import './TodoStyle.css'

type Props = {
  todo: Todo;
  deleteTodo: (todo: Todo) => void
  check: (todo: Todo) => void
  unCheck: (todo: Todo) => void
}

function TodoComponent({ todo, deleteTodo, check, unCheck }: Props) {
  const toggleTodo = () => {
    if (todo.checkTODO === 1) {
      unCheck(todo)
    } else {
      check(todo)
    }
  }
  return (
    <div className="component">
      <div className={`indicator indicator--${todo.typeTODO}${todo.checkTODO === 1 ? ' indicator--CHECKED':''}`}></div>
      <div className={`title-todo${todo.checkTODO === 1 ? ' title-todo--CHECKED':''}`}>
        {todo.titleTODO}
      </div>
      <div className="type"></div>
      <div className="done">
        <Checkbox checked={todo.checkTODO === 1} onClick={toggleTodo}/>
      </div>
      <Trash2 className="delete" onClick={() => deleteTodo(todo)}/>
    </div>

  )
}

export default TodoComponent

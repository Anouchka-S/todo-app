import {
  Button,
  TextField,
  Select,
  MenuItem
} from '@mui/material';
import {useForm} from 'react-hook-form';
import {Todo} from '../../type/Todo';
import './TodoFormStyle.css'
import {XCircle} from "react-feather";

type Props = {
  close: () => void
  addTodo: (todo: Todo) => void;
}

function TodoFormComponent({close, addTodo}: Props) {

  const {register, handleSubmit} = useForm<Todo>();
  const onSubmit = (data: Todo) => {
    addTodo(data);
    console.table(data);
  }

  return (
    <form onSubmit={handleSubmit((data: Todo) => onSubmit(data))}>
      <div className="mask" onClick={close}>
        <div className="popin" onClick={(event) => event.stopPropagation()}>
          <div className="input-container">
            <div className="title-popin">
              <span>Nouvelle Todo</span>
              <div className="close">
                <XCircle onClick={close}/>
              </div>
            </div>
            <TextField id="titleTODO" label="titre" variant="outlined" {...register("titleTODO")} />
            <div className="space" />
              <Select {...register("typeTODO")}>
                <MenuItem value={"EASY"}>À faire</MenuItem>
                <MenuItem value={"MEDIUM"}>Urgent</MenuItem>
                <MenuItem value={"HARD"}>Très urgent</MenuItem>
              </Select>
          </div>
            <Button variant="contained" type="submit">
              <span>Enregistrer</span>
            </Button>
        </div>
      </div>
    </form>
  )
}

export default TodoFormComponent

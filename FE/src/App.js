import axios from 'axios';
import './App.css';

function App() {
  const regist=()=>{
    let data={
      "userId":"test",
      "userPw":"test",
    };
    axios({
      url: "http://localhost:9999/user/regist",
      header: {
        Accept: "application/json",
        "Content-type": "application/json;charset=UTF-8",
      },
      method: "POST",
      data,
    })
      .then((response) => {
        console.log(response);
        alert("REGIST SUCCESS");
      })
      .catch((error) => {
        console.log(error);
      });
  }

  const login=()=>{
    let data={
      "userId":"test",
      "userPw":"test",
    };
    axios({
      url: "http://localhost:9999/user/login",
      header: {
        Accept: "application/json",
        "Content-type": "application/json;charset=UTF-8",
      },
      method: "POST",
      data,
    })
      .then((response) => {
        console.log(response);
        alert("LOGIN SUCCESS");
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="App">
      <button type="button" onClick={regist()}>REGIST</button>
      <br/>
      <button type="button" onClick={login()}>LOGIN</button>
    </div>
  );
}

export default App;

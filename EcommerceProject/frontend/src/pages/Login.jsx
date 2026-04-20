import { useState } from "react";
import API from "../services/api";

function Auth() {
  const [isLogin, setIsLogin] = useState(true);

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      if (isLogin) {
        const response = await API.post("/users/login", {
          email,
          password,
        });

        console.log("Login response:", response.data);
        const { token } = response.data;
        localStorage.setItem("token", token);
        alert("Login successful!");
      } else {
        const response = await API.post("/users/register", {
          name,
          email,
          password,
        });

        console.log("Register response:", response.data);
        alert("Registration successful!");
      }
    } catch (error) {
      console.error("Auth error:", error);
      alert(isLogin ? "Login failed!" : "Registration failed!");
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.box}>
        <h2>{isLogin ? "Login" : "Register"}</h2>

        <form onSubmit={handleSubmit} style={styles.form}>
          {!isLogin && (
            <input
              type="text"
              placeholder="Enter name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              style={styles.input}
              required
            />
          )}

          <input
            type="email"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            style={styles.input}
            required
          />

          <input
            type="password"
            placeholder="Enter password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            style={styles.input}
            required
          />

          <button type="submit" style={styles.button}>
            {isLogin ? "Login" : "Register"}
          </button>
        </form>

        <p
          onClick={() => setIsLogin(!isLogin)}
          style={{ marginTop: "10px", cursor: "pointer", color: "#007bff" }}
        >
          {isLogin
            ? "Don't have an account? Register"
            : "Already have an account? Login"}
        </p>
      </div>
    </div>
  );
}

const styles = {
  container: {
    height: "100vh",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    background: "#f5f5f5",
  },
  box: {
    padding: "30px",
    background: "white",
    borderRadius: "10px",
    boxShadow: "0 0 10px rgba(0,0,0,0.1)",
    width: "300px",
    textAlign: "center",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "10px",
  },
  input: {
    padding: "10px",
    border: "1px solid #ccc",
    borderRadius: "5px",
  },
  button: {
    padding: "10px",
    background: "#007bff",
    color: "white",
    border: "none",
    borderRadius: "5px",
    cursor: "pointer",
  },
};

export default Auth;
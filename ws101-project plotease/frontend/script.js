// ===============================
// PLOTEASE AUTH SYSTEM (LOGIN + SIGNUP)
// ===============================

// -------------------------------
// TOAST NOTIFICATION SYSTEM
// -------------------------------
function showToast(message, type = "info") {
  const container = document.getElementById("toast-container");

  const toast = document.createElement("div");
  toast.className = "toast";

  let color = "#6c8ef5";
  if (type === "error") color = "#f87171";
  if (type === "success") color = "#4ade80";

  toast.style.borderLeft = `4px solid ${color}`;
  toast.textContent = message;

  container.appendChild(toast);

  setTimeout(() => {
    toast.remove();
  }, 3000);
}

// ===============================
// SIGNUP FUNCTION (signup.html)
// ===============================
function handleSignup() {
  const userId = document.getElementById("userId")?.value.trim();
  const fullName = document.getElementById("fullName")?.value.trim();
  const studentId = document.getElementById("studentId")?.value.trim();
  const email = document.getElementById("email")?.value.trim();
  const password = document.getElementById("password")?.value.trim();

  if (!userId || !fullName || !studentId || !email || !password) {
    showToast("Please fill in all fields", "error");
    return;
  }

  let users = JSON.parse(localStorage.getItem("plotease_users")) || [];

  // check duplicates
  const exists = users.some(
    u => u.email === email || u.userId === userId || u.studentId === studentId
  );

  if (exists) {
    showToast("User already exists", "error");
    return;
  }

  const newUser = {
    userId,
    fullName,
    studentId,
    email,
    password
  };

  users.push(newUser);
  localStorage.setItem("plotease_users", JSON.stringify(users));

  showToast("Account created successfully!", "success");

  setTimeout(() => {
    window.location.href = "login.html";
  }, 1200);
}

// ===============================
// LOGIN FUNCTION (login.html)
// ===============================
function handleLogin() {
  const input = document.getElementById("login-username")?.value.trim();
  const password = document.getElementById("login-password")?.value.trim();

  if (!input || !password) {
    showToast("Please enter login credentials", "error");
    return;
  }

  let users = JSON.parse(localStorage.getItem("plotease_users")) || [];

  const user = users.find(u =>
    (u.email === input ||
     u.userId === input ||
     u.studentId === input) &&
    u.password === password
  );

  if (!user) {
    showToast("Invalid username or password", "error");
    return;
  }

  // save session
  localStorage.setItem("plotease_session", JSON.stringify(user));

  showToast(`Welcome, ${user.fullName}`, "success");

  setTimeout(() => {
    window.location.href = "dashboard.html";
  }, 1200);
}

// ===============================
// AUTO SESSION CHECK
// ===============================
function checkSession() {
  const session = localStorage.getItem("plotease_session");

  if (session) {
    const user = JSON.parse(session);

    // If already logged in and on login page → redirect
    if (window.location.pathname.includes("login.html")) {
      window.location.href = "dashboard.html";
    }
  }
}

// Run on load
checkSession();
const API_URL = "http://localhost:8080/api";

export const login = async (username, password) => {
  try {
    const response = await fetch(`${API_URL}/login`, {
      method: 'POST',  // Ensure this is POST, not GET
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
      const data = await response.json();
      sessionStorage.setItem("isAuthenticated", "true");
      sessionStorage.setItem("token", data.token);
      return true;
    } else {
      const errorData = await response.json();
      console.error('Login failed:', errorData);
      return false;
    }
  } catch (error) {
    console.error('Network error or invalid response:', error);
    return false;
  }
};

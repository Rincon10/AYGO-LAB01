const getNameInputValue = () => document.getElementById("nameInput").value;

const createRequestBody = (name) => JSON.stringify({ name });

const handleResponse = async (response) => {
  const data = await response.json();
  alert(`Response: ${data.message} at ${data.timestamp}`);
};

const handleError = (error) => {
  console.error("Error:", error);
};

const sendRequest = async (name) => {
  const response = await fetch("/api/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: createRequestBody(name),
  });
  return response;
};

const submitName = async (event) => {
  event.preventDefault(); // Evitar la recarga de la página

  const name = getNameInputValue();

  try {
    const response = await sendRequest(name);
    await handleResponse(response);
  } catch (error) {
    handleError(error);
  }
};

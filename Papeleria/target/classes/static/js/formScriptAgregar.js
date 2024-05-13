const formButton = document.querySelector('.agregar');

const floatingForm = document.getElementById('floatingForm');

function openForm() {
  floatingForm.style.display = 'block';
}

function closeForm() {
  floatingForm.style.display = 'none';
}

formButton.addEventListener('click', openForm);
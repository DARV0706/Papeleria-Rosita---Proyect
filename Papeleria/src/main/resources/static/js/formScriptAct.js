const formButtonAct = document.querySelector('.actualizar');
const floatingFormAct = document.getElementById('floatingFormAct');

function openFormAct() {
    floatingFormAct.style.display = 'block';
}

function closeFormAct() {
    floatingFormAct.style.display = 'none';
}

formButtonAct.addEventListener('click', openFormAct);
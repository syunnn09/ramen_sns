const form = document.getElementById('form');
const submitButton = document.getElementById('submitButton');
const email = document.getElementById('email');
const password = document.getElementById('password');
const confirm = document.getElementById('confirm');
const userName = document.getElementById('userName');

const disable = () => {
    submitButton.classList.add('disable');
}

form.addEventListener('change', () => {
    if (!email.value || !password.value || !confirm.value || !userName.value) {
        disable();
        return;
    }

    submitButton.classList.remove('disable');
})

form.addEventListener('submit', (e) => {
    e.preventDefault();

    console.log(password.value, confirm.value)
    if (password.value !== confirm.value) {
        confirm.setCustomValidity('パスワードが違います');
        return;
    }

    form.submit();
})
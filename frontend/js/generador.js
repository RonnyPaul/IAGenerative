// Cargar lista de niños al iniciar
window.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8081/ninio/todos')
        .then(res => res.json())
        .then(data => {
            const select = document.getElementById('ninio');
            if (data.data && Array.isArray(data.data)) {
                data.data.forEach(ninio => {
                    const option = document.createElement('option');
                    option.value = ninio.id_ni || ninio.id;
                    option.textContent = ninio.nombre_nino;
                    select.appendChild(option);
                });
            }
        });
});

// Generar actividad con IA
const generarBtn = document.getElementById('generar-btn');
generarBtn.addEventListener('click', () => {
    const prompt = document.getElementById('prompt').value;
    if (!prompt) return;
    generarBtn.disabled = true;
    fetch('http://localhost:8081/api/prompt?prompt=' + encodeURIComponent(prompt))
        .then(res => res.text())
        .then(texto => {
            document.getElementById('descripcion').value = texto;
        })
        .finally(() => { generarBtn.disabled = false; });
});

// Guardar actividad
const form = document.getElementById('form-generador');
form.addEventListener('submit', e => {
    e.preventDefault();
    const descripcion = document.getElementById('descripcion').value;
    const fecha = document.getElementById('fecha').value;
    const idninio = document.getElementById('ninio').value;
    if (!descripcion || !fecha || !idninio) return;
    fetch('http://localhost:8081/actividad', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ descripcion_act: descripcion, fecha_act: fecha, idninio: idninio })
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById('mensaje').textContent = data.mensaje || 'Actividad guardada';
        form.reset();
    })
    .catch(() => {
        document.getElementById('mensaje').textContent = 'Error al guardar la actividad';
    });
}); 
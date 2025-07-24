window.addEventListener('DOMContentLoaded', () => {
    cargarActividades();
});

function cargarActividades() {
    fetch('http://localhost:8081/actividad/todos')
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector('#tabla-actividades tbody');
            tbody.innerHTML = '';
            if (data.data && Array.isArray(data.data)) {
                data.data.forEach(act => {
                    const tr = document.createElement('tr');
                    tr.innerHTML = `
                        <td>${act.id || act.idActDTO || ''}</td>
                        <td>${act.descripcion_act || ''}</td>
                        <td>${act.fecha_act || ''}</td>
                        <td>${act.ninio ? (act.ninio.nombre_nino || '') : ''}</td>
                        <td style="text-align:center;"><button class="eliminar-btn" data-id="${act.id || act.idActDTO}"><i class="fa-solid fa-trash"></i></button></td>
                    `;
                    tbody.appendChild(tr);
                });
            }
            agregarEventosEliminar();
        });
}

function agregarEventosEliminar() {
    document.querySelectorAll('.eliminar-btn').forEach(btn => {
        btn.addEventListener('click', function() {
            const id = this.getAttribute('data-id');
            if (confirm('¿Seguro que deseas eliminar esta actividad?')) {
                fetch(`http://localhost:8081/actividad/${id}`, {
                    method: 'DELETE'
                })
                .then(res => res.json())
                .then(() => {
                    cargarActividades();
                });
            }
        });
    });
} 
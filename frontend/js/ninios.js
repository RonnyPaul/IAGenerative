window.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8081/ninio/todos')
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector('#tabla-ninios tbody');
            tbody.innerHTML = '';
            if (data.data && Array.isArray(data.data)) {
                data.data.forEach(ninio => {
                    const tr = document.createElement('tr');
                    tr.innerHTML = `
                        <td>${ninio.nombre_nino || ''}</td>
                        <td>${ninio.fechaNac || ''}</td>
                    `;
                    tbody.appendChild(tr);
                });
            }
        });
}); 